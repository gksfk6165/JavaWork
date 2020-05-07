package com.lec.java.switch05;

public class Switch05Main {

	// enum 타입 정의하는 방법:
	// enum 이름 {}
	// enum 타입 정의 메소드 안에서는 할 수 없다.

	enum Days {
		sun, mon, tue, wed, thu, fri, sat
	}

	public static void main(String[] args) {
		System.out.println("enum 타입을 switch에서 사용하기");

		// TODO
		Days day1=Days.tue;
		System.out.println(day1);
		Days day2=Days.mon;
		System.out.println(day2);
		
		switch (day1) {
		case sun:
			System.out.println("일요일");
			break;
		case mon:
			System.out.println("월요일");
			break;
		case tue:
			System.out.println("하요일");
			break;
		case wed:
			System.out.println("수요일");
			break;
		case thu:
			System.out.println("목요일");
			break;
		case fri:
			System.out.println("금요일");
			break;
		case sat:
			System.out.println("토요일");
			break;

		default:
			break;
		}
		
		
		
		
		
		System.out.println("\n프로그램 종료");
	} // end main()

} // end class
