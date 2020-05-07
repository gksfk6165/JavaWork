package com.lec.java.firsjava;

/*
모든 자바 프로그램은 main() 메소드로부터 '시작'한다
프로그램 실행순서는 '시작' 부터 한 문장(Statement) 씩 실행되는 것이 원칙
문장의 끝은 반드시 세미콜론 ';' 으로 마무리 해야 한다
*/


public class FirstJava {
	public static void main(String[] args) {
		System.out.println("My First Java App");
		System.out.println(123)  ;
		System.out.println();
		System.out.println(10+20);
		System.out.println("10+20"); //"  ~~  " 문자열 , 문자열출력시 ""없으면 오류
//		System.out.println(안녕하세요); 예시
		
		System.out.println(3.141592*10*10);
		System.out.println(10*10/2);
		
		// + 더하기연산자 여러가지동작
		System.out.println("안녕하세요"+" 어려분");
		System.out.println("결과:"+ 10);
		System.out.println("결과:"+ 10 + 20);
		System.out.println("결과:"+ (10 + 20));
		
		//사칙연산
		System.out.println("10+20="+(10 + 20));
		System.out.println("10-20="+(10 - 20));
		System.out.println("10*20="+(10 * 20));
		
		//정수나누기 정수는 정수
		System.out.println("10/20="+(10 / 20));
		System.out.println("10/20="+(10.0 / 20.0));
		System.out.println("10/20="+(double)10 / 20);
		
		//이스케이프문자
		//문자열안에서 특수한 문자 출력 \함께사용
		// \n 줄바꿈,	\t" 탭문자,  \\ 역슬래쉬
		System.out.println("she says \"hi\"");
		System.out.println("\t1234\t456");
		System.out.println("\t10\t4");
		System.out.println("\n1234\t4");
		System.out.println("\\10\t4");
		System.out.println("Avengers\n\\Endgame\\");
	}
}
