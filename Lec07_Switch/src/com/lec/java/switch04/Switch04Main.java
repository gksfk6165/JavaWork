package com.lec.java.switch04;

public class Switch04Main {

	public static void main(String[] args) {
		System.out.println("String 타입을 switch에서 사용하기");
		
		String lan="C++";
		
		
		switch (lan) {
		case "Java":
			System.out.println("Java");
			break;
		case "C++":
			System.out.println("C++");
			break;
		case "Swift":
			System.out.println("Swift");
			break;

		default:
			System.out.println("?");
			break;
		}

		System.out.println("\n프로그램 종료");
	} // end main()

} // end class









