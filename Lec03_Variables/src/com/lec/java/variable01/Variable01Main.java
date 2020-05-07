package com.lec.java.variable01;
/*
변수 (Variables) :
	값을 담는 공간.  변수이름(variable name)을 부여해서 관리
	
변수는 사용하기 전에 먼저 '선언(declaration)' 해야 한다
변수 선언:
	변수타입 변수이름;

변수의 초기화 (initialization)
변수에 최초로 값(value) 을 대입 (assignment) 하는 것.
변수(지역변수)를 사용/참조하려면 그전에 반드시 초기화가 되어야 함.

*/
public class Variable01Main {
	
	public static void main(String[] args) {
		
		//변수선언
		//변수타입 변수이름 ;
		//int - 정수타입
		//변수의초기화
		//변수 초기화 전에 사용하려면 에러발생
		int num1=0;// int타입 변수 num1 선언
		int num2=0;// int타입 변수 num2 선언
		int num3=0;// int타입 변수 num3 선언
		int num4=0;// int타입 변수 num4 선언
		
		num1=10; //= 대입연산자   대입(assign)
		num2=20;
		num3=30;
		num4=num2+num3;
		
		System.out.println("변수(Variable)");
		System.out.println(num1);
		System.out.println(num4);
		
		num1=100;  //변수값 변경가능 - 그렇기에 변수
		
		System.out.println(num1+num2);
		System.out.println(num3*num2);
		System.out.println(num1-num3);
		System.out.println((double)num4/num1);
		
		System.out.println();
		
		
		
	}//end main()

}//end class()
