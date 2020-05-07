package phonebook01.class01;

import java.util.Scanner;


//View 객체
public class PhonebookMain {

	PhonebookModel [] bookData=new PhonebookModel[2];
	Scanner sc;
	static int phoneBookSize=0;
	public static void main(String[] args) {
		PhonebookMain app=new PhonebookMain();
		app.init();
		app.run();
		app.exit();
	}//end main()
	//응용프로그램을 초기화
	public void init() {
		sc=new Scanner(System.in);
	}
	//응용프로그램 구동
	public void run() {
		System.out.println("전호번호부v1.0");
		while (true) {
			showMenu();
			int menu=sc.nextInt();
			sc.nextLine();
			switch (menu) {
			case 1:
				System.out.println("전화번호 입력");
				insertPhoneBook(sc);
				break;
			case 2:
				System.out.println("전화번호부 열람");
				showPhoneBook();
				break;
			case 3:
				System.out.println("프로그램 종료");
				break;
			default:
				System.out.println("잘못입력");
			}
		}
	}
	//전화번호 입력
	public void insertPhoneBook(Scanner sc) {
		PhonebookModel pbm=new PhonebookModel();
		if(phoneBookSize<bookData.length) {
			System.out.println("이름입력 : ");
			pbm.setUid(phoneBookSize+1);
			pbm.setName(sc.next());
			System.out.println("전화번호입력 : ");
			pbm.setPhoneNum(sc.next());
			System.out.println("이메일입력: ");
			pbm.setEmail(sc.next());
			bookData[phoneBookSize]=pbm;
			System.out.println(phoneBookSize+1+" 번째 전화번호 추가 성공");
		}else {
			System.out.println("가득찼습니다");
			return;
		}
		phoneBookSize++;
	}
	public void showPhoneBook() {
		String showPhoneString="";
		for (int i = 0; i < phoneBookSize; i++) {
			showPhoneString=bookData[i].toString();
			System.out.println(showPhoneString);
		}
	}
	
	private void showMenu() {
		System.out.println("전화번호부 프로그램");
		System.out.println("=============");
		System.out.println("1.입력 ");
		System.out.println("2.열람 ");
		System.out.println("3.종료 ");
		
	}
	//응용프로그램 종료
	public void exit() {
		sc.close();
	}
}
