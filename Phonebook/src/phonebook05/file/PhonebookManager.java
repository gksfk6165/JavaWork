package phonebook05.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

import javax.imageio.IIOException;

// CONTROLLER 객체
//   어플리케이션의 동작, 데이터 처리(CRUD), (Business logic 담당)
public class PhonebookManager implements Pb, Closeable {
	public static final String PB_DATA_DIR="data";
	public static final String PB_DATA_FILE ="phonebook.txt";
	private File pbDir;
	private File pbFile;
	
	private ArrayList<PhonebookModel> pbList = new ArrayList<PhonebookModel>();

	// singleton적용
	private PhonebookManager() {
		// TODO 파일읽어오기 // FileNotFoundException
		// 파일이 존재하면 파일 읽어들이기 --?pbList;
		
		pbDir=new File(PB_DATA_DIR);
		
		if(!pbDir.exists()) {
			if(pbDir.mkdir()) {
				System.out.println("폴더 생성 성공");
			}else {
				System.out.println("폴더 생성 실패");
			}
		}else {
			System.out.println("폴더 이미 존재"+pbDir.getAbsolutePath());
		}
		
		pbFile=new File(pbDir,PB_DATA_FILE);
		
		if(!pbFile.exists()) {
			System.out.println("파일에서 데이터 읽습니다.......");
			BufferedReader br=null;
			try {
				br=new BufferedReader(new FileReader(pbFile));
				String str;
				String []splitStr;
				while ((str=br.readLine())!=null) {
					PhonebookModel pbModel = new PhonebookModel();
					splitStr=str.split(",");
					pbModel.setUid(Integer.parseInt(splitStr[0]));
					pbModel.setName(splitStr[1]);
					pbModel.setPhoneNum(splitStr[2]);
					pbModel.setMemo(splitStr[3]);
					pbModel.setRegDate(new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy",Locale.ENGLISH).parse(splitStr[4]));
					pbList.add(pbModel);
				}
				System.out.println(pbList.size()+"개의데이터를 읽었습니다.");
			} catch (FileNotFoundException e) {
				e.getStackTrace();
			} catch (IOException e) {
				e.getStackTrace();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			System.out.println("읽어올 파일이 없습니다.");
		}
		
		
	}

	private static PhonebookManager instance = null;

	public static PhonebookManager getInstance() {
		if (instance == null) {
			instance = new PhonebookManager();
		}
		return instance;
	} // end getInstance()

	// 전화번호부 생성 등록
	@Override
	public int insert(String name, String phoneNum, String memo) {

		// 매개변수 검증 : 이름 필수
		if (name == null || name.trim().length() == 0) {
			throw new PhonebookException("insert() 이름입력오류: ", Pb.ERR_EMPTY_STRING);
		}
		int uidCount = getMaxUid();
		PhonebookModel pbModel = new PhonebookModel();
		pbModel.setName(name);
		pbModel.setPhoneNum(phoneNum);
		pbModel.setMemo(memo);
		pbModel.setUid(uidCount + 1);
		pbList.add(pbModel);

		return 1;
	}

	@Override
	public PhonebookModel[] selectAll() {

		PhonebookModel[] pbmArray = new PhonebookModel[pbList.size()];
		for (int i = 0; i < pbList.size(); i++) {
			pbmArray[i] = pbList.get(i);
		}
		return pbmArray;
		// return pbList.toArray(new PhonebookModel[pbList.size());
	}

	// 특정 uid 의 데이터 검색 리턴
	// 못찾으면 null 리턴
	@Override
	public PhonebookModel selectByUid(int uid) {

		for (int i = 0; i < pbList.size(); i++) {
			if (pbList.get(i).getUid() == uid) {
				return pbList.get(i);
			}
		}

		return null; // 못찾으면 null 리턴
	}// end selectByUid()

	@Override
	public int updateByUid(int uid, String name, String phoneNum, String memo) {

		// 매개변수 검증
		if (uid < 1)
			throw new PhonebookException("update() uid 오류: " + uid, Pb.ERR_UID);

		if (name == null || name.trim().length() == 0) // 이름 필수
			throw new PhonebookException("update() 이름입력 오류: ", Pb.ERR_EMPTY_STRING);

		// 특정 uid 값을 가진 데이터의 배열 인덱스 찾기
		int index = findIndexByUid(uid);
		if (index < 0)
			throw new PhonebookException("update() 없는 uid: " + uid, Pb.ERR_UID);

		pbList.get(index).setName(name);
		pbList.get(index).setPhoneNum(phoneNum);
		pbList.get(index).setMemo(memo);

		return 1;
	}

	@Override
	public int deleteByUid(int uid) {
		// 매개변수 검증
		if (uid < 1)
			throw new PhonebookException("deleteByUid() uid 오류: " + uid, Pb.ERR_UID);

		int index = findIndexByUid(uid);
		if (index < 0)
			throw new PhonebookException("deleteByUid() 없는 uid: " + uid, Pb.ERR_UID);

		pbList.remove(index);

		return 1;
	}

	// 현재 데이터중 가장 큰 uid 값을 찾아서 리턴
	private int getMaxUid() {

		int maxUid = 0;
		for (int i = 0; i < pbList.size(); i++) {

			if (maxUid < pbList.get(i).getUid()) {
				maxUid = pbList.get(i).getUid();
			}
		}
		return maxUid;
	}

	// 특정 uid 값을 가진 데이터의 배열 인덱스 찾기
	// 못찾으면 -1 리턴
	private int findIndexByUid(int uid) {

		for (int i = 0; i < pbList.size(); i++) {
			if (pbList.get(i).getUid() == uid) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public void close() throws IIOException {
		try {

			FileOutputStream output = new FileOutputStream(pbFile, true);
			OutputStreamWriter writer = new OutputStreamWriter(output, "UTF-8");
			BufferedWriter out = new BufferedWriter(writer);

			for (int i = 0; i < pbList.size(); i++) {
				out.write(pbList.get(i).getUid() + ",");
				out.write(pbList.get(i).getName() + ",");
				out.write(pbList.get(i).getPhoneNum() + ",");
				out.write(pbList.get(i).getMemo() + ",");
				out.write(pbList.get(i).getRegDate() + ",");
				out.append("\n");
			}
			System.out.println("파일 저장 완료!");
			out.flush();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

} // end PhonebookManager
// 예의 클래스 정의
// 예외발생하면 '에러코드' + '에러메세지'를 부여하여 관리하는게 좋다.

class PhonebookException extends RuntimeException {

	private int errCode = Pb.ERR_GENERIC;

	public PhonebookException() {
		super("Phonebook 예외 발생");
	}

	public PhonebookException(String msg) {
		super(msg);
	}

	public PhonebookException(String msg, int errCode) {
		super(msg);
		this.errCode = errCode;
	}

	// Throwable 의 getMessage 를 오버라이딩 가능
	@Override
	public String getMessage() {
		String msg = "ERR-" + errCode + "]" + Pb.ERR_STR[errCode] + " " + super.getMessage();
		return msg;
	}

} // end PhonebookException
