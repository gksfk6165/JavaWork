package phonebook02.mvc;

import java.util.Scanner;


//View 객체
//사용자와의 입출력 담당 
public class PhonebookMain {

	private Scanner sc;
	private PhoneBookManger pbCtrl;
	public static void main(String[] args) {
		PhonebookMain app=new PhonebookMain();
		app.init();
		app.run();
		app.exit();
	}//end main()
	//응용프로그램을 초기화
	public void init() {
		sc=new Scanner(System.in);
		pbCtrl=PhoneBookManger.getInstance(); //컨트롤러 생성
	}
	//응용프로그램 구동
	public void run() {
		System.out.println(PhoneBookController.version);
		while (true) {
			showMenu();
			int menu=sc.nextInt();
			sc.nextLine();
			switch (menu) {
			case Menu.MENU_INSERT:
				insertPhoneBook();
				break;
			case Menu.MENU_DELETE:
				deletePhoneBook();
				break;
			case Menu.MENU_UPDATE:
				upDatePhoneBook();
				break;
			case Menu.MENU_LIST:
				listPhoneBook();
				break;
			case Menu.MENU_QUIT:
				System.out.println("프로그램을 종료합니다.");
				return;
			default:
				System.out.println("잘못입력하셨습니다");
			}
		}
	}
	//전화번호 입력
	public void insertPhoneBook() {
		
		System.out.println("===========입력메뉴==========");
		System.out.println("이름입력:");
		String pName=sc.nextLine();
		System.out.println("전하번호입력:");
		String pNumber=sc.nextLine();
		System.out.println("메모:");
		String pMemo=sc.nextLine();
		
		int result=pbCtrl.insert(pName,pNumber,pMemo);
		if(result==PhoneBookController.QUERY_FAIL) {
			System.out.println("입력실패");
		}else {
			System.out.println(result+"개의 전화번호입력성공");
		}
		
	}
	public void listPhoneBook() {
		PhonebookModel[] data=pbCtrl.selectAll();
		//view 역할 사용자 입출력 
		
		System.out.println("총"+data.length+"명의 전화번호 출력합니다");
		for(PhonebookModel e:data) {
			System.out.println(e);
		}
	}
	
	//전화번호부 수정
	public void upDatePhoneBook() {
		//view 사용자입출력
		System.out.println("-----수정메뉴-----");
		System.out.println("수정할 번호 입력:");
		int uid=sc.nextInt();
		sc.nextLine();
		
		//컨트롤러 연결
		System.out.println("이름입력:");
		String pName=sc.nextLine();
		System.out.println("전하번호입력:");
		String pNumber=sc.nextLine();
		System.out.println("메모:");
		String pMemo=sc.nextLine();
		
		int result=pbCtrl.updatByUid(uid,pName,pNumber,pMemo);
		
		if(result==PhoneBookController.QUERY_FAIL) {
			System.out.println("수정실패");
		}else {
			System.out.println(result+"개의 전화번호수정성공");
		}
		
	}
	//전화번호부 수정
		public void deletePhoneBook() {
			//view 사용자입출력
			System.out.println("-----삭제메뉴-----");
			System.out.println("삭제할 번호 입력:");
			int uid=sc.nextInt();
			sc.nextLine();
			
			if(pbCtrl.selectByUid(uid)==null) {
				System.out.println("존재하지않는 아이디: "+uid);
				return;
			}
			
			int result = pbCtrl.deleteByUid(uid);
			if(result == PhoneBookController.QUERY_FAIL) {
				System.out.println("삭제 실패");
			} else {
				System.out.println(result + " 개의 전화번호 삭제 성공");
			}
			
		}
	
	private void showMenu() {
		
		System.out.println("전화번호부 프로그램");
		System.out.println("=============");
		System.out.println("0.종료 ");
		System.out.println("1.입력 ");
		System.out.println("2.열람 ");
		System.out.println("3.수정 ");
		System.out.println("4.삭제 ");
		System.out.println("=============");
		System.out.println("선택: ");
		
	}
	//응용프로그램 종료
	public void exit() {
		sc.close();
	}
}
