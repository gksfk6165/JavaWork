package phonebook06.db;

import java.io.Closeable;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
// CONTROLLER 객체
//   어플리케이션의 동작, 데이터 처리(CRUD), (Business logic 담당)

// by 윤지우
public class PhonebookManager implements Pb, Closeable {

	public static final String DRIVER ="oracle.jdbc.driver.OracleDriver";
	public static final String URL ="jdbc:oracle:thin:@localhost:1521:XE";
	public static final String USER = "scott0316";
	public static final String PASSWD = "tiger0316";
	
	Connection conn=null;		
	Statement stmt = null;
	PreparedStatement pstmt=null;
	ResultSet rs = null;
	
	private PhonebookManager() {
		// TODO:
		// JDBC 프로그래밍
		//  클래스 로딩
		//  연결 Connection
		//  Statement (필요하다면) 생성

		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL, USER, PASSWD);
			System.out.println("======================conn======================");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
		int cnt = 0;
		// TODO
		// SQL_INSERT 사용하여 INSERT
		// PreparedStatement 사용..
		try {
			pstmt=conn.prepareStatement(SQL_INSERT);
			pstmt.setString(1, name);
			pstmt.setString(2, phoneNum);
			pstmt.setString(3, memo);
			rs = pstmt.executeQuery();
			cnt=rs.getRow();
			rs.close();
			pstmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 1;
	}

	@Override
	public PhonebookModel[] selectAll() {
		// TODO
		System.out.println("들어옴");
		PhonebookModel[] pbmArray=null;
		List<PhonebookModel> pbList=null;
		// SQL_SELECT_ALL 사용
		try {
			int index;
			stmt = conn.createStatement();
			rs = stmt.executeQuery(SQL_SELECT_ALL);
			index=rs.getRow();
			pbmArray = new PhonebookModel[index];
			pbList = new ArrayList<PhonebookModel>();
			while (rs.next()) {
				pbList.add(new PhonebookModel(rs.getInt(COL_LABEL_UID),
						rs.getString(COL_LABEL_NAME),
						rs.getString(COL_LABEL_PHONENUM), 
						rs.getString(COL_LABEL_MEMO), 
						rs.getTimestamp(COL_LABEL_REGDATE)));
			}
			rs.close();
			stmt.close();
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pbList.toArray(new PhonebookModel[pbList.size()]);
	}

	// 특정 uid 의 데이터 검색 리턴
	// 못찾으면 null 리턴
	@Override
	public PhonebookModel selectByUid(int uid) {
		PhonebookModel pm=new PhonebookModel();
		String url="SELECT * FROM PHONEBOOK WHERE PB_UID="+uid+"";
		try {
			pstmt=conn.prepareStatement(url);
			rs=pstmt.executeQuery();
			while (rs.next()) {
				if(rs.getInt(COL_LABEL_UID)==uid) {
					pm.setUid(rs.getInt(COL_LABEL_UID));
					pm.setName(rs.getString(COL_LABEL_NAME));
					pm.setPhoneNum(rs.getString(COL_LABEL_PHONENUM));
					pm.setMemo(rs.getString(COL_LABEL_MEMO));
					pm.setRegDate(rs.getDate(COL_LABEL_REGDATE));
					return pm;
				}
			}
			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
		int cnt = 0;
		// SQL_UPDATE_BY_UID  사용
		try {
			pstmt=conn.prepareStatement(SQL_UPDATE_BY_UID);
			pstmt.setString(1, name);
			pstmt.setString(2, phoneNum);
			pstmt.setString(3, memo);
			pstmt.setInt(4, uid);
			rs = pstmt.executeQuery();
			cnt=rs.getRow();
			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 1;
	}

	@Override
	public int deleteByUid(int uid) {
		// 매개변수 검증
		if (uid < 1)
			throw new PhonebookException("deleteByUid() uid 오류: " + uid, Pb.ERR_UID);
		int cnt = 0;
		// TODO
		// SQL_DELETE_BY_UID 사용
		try {
			pstmt=conn.prepareStatement(SQL_DELETE_BY_UID);
			pstmt.setInt(1, uid);
			rs = pstmt.executeQuery();
			cnt=rs.getRow();
			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 1;
	}

	// 현재 데이터중 가장 큰 uid 값을 찾아서 리턴
	public int getMaxUid() {
		int maxUid = 0;
		PhonebookModel pm=new PhonebookModel();
		String url="SELECT MAX(PB_UID) as MAX_ID FROM PHONEBOOK";
		try {
			pstmt=conn.prepareStatement(url);
			rs=pstmt.executeQuery();
			
			while (rs.next()) {
				maxUid=rs.getInt("MAX_ID");
			}
			rs.close();
			pstmt.close();
		}catch (Exception e) {
			// TODO: handle exception
		}
		return maxUid;
	}


	@Override
	public void close() throws IOException {

		// TODO
		// ResultSet
		// Statement 
		// Connection
		// 들 close()

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
