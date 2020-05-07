package phonebook05.file;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

// model객체
// 데이터 표현 객체
public class PhonebookModel implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7457878413286439105L;
	
	private int uid;
	private String name;
	private String phoneNum;
	private String memo; //메모
	private Date regDate;  //등록일시
	
	public PhonebookModel() {
		this.uid=0;
		this.name="";
		this.phoneNum="";
		this.memo="";
		this.regDate=new Date(); //생성되는 현재시간
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public PhonebookModel(String name,String phoneNum,String memo) {
		this();
		this.name=name;
		this.phoneNum=phoneNum;
		this.memo=memo;
	}
	public PhonebookModel(int uid,String name,String phoneNum,String memo,Date regDate) {
		this();
		this.name=name;
		this.phoneNum=phoneNum;
		this.memo=memo;
	}
	
	
	
	@Override
	public String toString() {
		String str=String.format("%3d|이름:%s | 전화번호:%s | 메모:%s |%20s",uid,name,phoneNum,memo,
				new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(regDate));
		
		return str;
	}
}
