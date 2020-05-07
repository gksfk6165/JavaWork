package com.lec.java.input02;

import java.util.Scanner;

//문자열입력
//char입력
public class Input02Main {
	public static void main(String[] args) {
		
		Scanner sc =new Scanner(System.in);
		
//		System.out.println("표준입력");
//		
//		//String 입력
//		System.out.println("이름  : ");
//		String name=sc.nextLine(); //엔터입력까지모든문자들을 문자열로 리턴
//		System.out.println("별명  : ");
//		String nick=sc.nextLine();
//		
//		
//		//Char 입력
//		//.nextChar() 존재않함
//		System.out.println("성별  : ");
//		char gender=sc.next().charAt(0); //엔터입력까지모든문자들을 문자열로 리턴
//		
//		System.out.println("이름 :"+name+", 별명 :"+nick+"  성별 :"+gender);
		
		System.out.println("나이 : ");
		int age=sc.nextInt();
		sc.nextLine();
		//숫자 입력받은뒤에 문자열 입력시에는 반드시 남아잇는 줄바꿈을  consume(버퍼에서제거)해야한다.
		System.out.println("주소 : ");
		String address=sc.nextLine();
		System.out.println("나이 :"+age+", 주소 :"+address);
		
		
		sc.close();
	}
}
