package phonebook02.mvc;

import java.util.Arrays;

//컨트롤러 객체
//어플리케이션의 동작 데이터처리 CRUD 비지니스로직 담당
public class PhoneBookManger implements PhoneBookController{
	public static final int MAX_DATA=3; //최대데이터개수
	
	// 싱글톤적용
	private PhoneBookManger() {
		
	}
	private static PhoneBookManger instance=null;
	public static PhoneBookManger getInstance() {
		if(instance==null) {
			instance=new PhoneBookManger();
		}
		return instance;
	}
	//배열로구현
	private PhonebookModel[] pbList=new PhonebookModel[MAX_DATA];
	
	//몇개의 데이터가 저장되었는지 
	private int count=0;
	
	 //전화번호부 생성등록
	@Override 
	public int insert(String name, String phoneNum, String memo) {
		
		int result=PhoneBookController.QUERY_FAIL;
		
		//매개변수 검증 이름필수
		if(name==null || name.trim().length()==0) {
			return result;
		}
		
		//만약 배열이 다 차있으면 , MAX_DATA 만큼 추가된 새 배열 작성
		if(count==pbList.length) {
			pbList=Arrays.copyOf(pbList,pbList.length+MAX_DATA);
		}
		pbList[count]=new PhonebookModel(name,phoneNum,memo);
		pbList[count].setUid(getMaxUid()+1);
		
		//uid 와 배열 인덱스는 다르다.
		
		count++;
		return 1;
	}

	@Override
	public PhonebookModel[] selectAll() {
	
		return Arrays.copyOfRange(pbList, 0, count);
	}

	@Override
	public PhonebookModel selectByUid(int uid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updatByUid(int uid, String name, String phoneNum, String memo) {
		int result=PhoneBookController.QUERY_FAIL;
		
		//매개변수 검증
		if(uid<1) {
			return result;
		}
		if(name==null ||name.trim().length()==0) {
			return result;
		}
		int index=findIndexByUid(uid);
		if(index<0) {
			return result;
		}
		pbList[index].setName(name);
		pbList[index].setPhoneNum(phoneNum);
		pbList[index].setMemo(memo);
		result=1;
		
		return result;
	}

	@Override
	public int deleteByUid(int uid) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public PhonebookModel choiceByUid(int uid) {
		// TODO Auto-generated method stub
		return null;
	}
	
	//현재 데이터중 가장큰 uid값을 찾아 리턴
	private int getMaxUid() {
		int maxUid=0;
		
		for (int i = 0; i < count; i++) {
			if(maxUid<pbList[i].getUid()) {
				maxUid=pbList[i].getUid();
			}
		}
		return maxUid;
	}
	
	// 특정 uid 값을 가진 데이터의 배열 인덱스 찾기
	// 못찾으면 -1 리턴
	private int findIndexByUid(int uid) {
		for(int index = 0; index < count; index++) {
			if(pbList[index].getUid() == uid) {
				return index;
			}
		}
		return -1;
	}
}
