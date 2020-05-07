package com.lec.java.variable03;

// 실수형 자료 타입: float(4바이트), double(8바이트)
// 정수형 자료 타입의 기본형은 int
// 실수형 자료 타입의 기본형은 double
public class Variable03Main {

	public static void main(String[] args) {
		System.out.println("변수 - 실수타입");

		double number1 = 3.141592;
		//float number2 = 3.14;  // 기본적으로 실수 리터럴은 double 로 인식
		//  float <- double 대입 불가
		
		// float 리터럴
		float number3 = 3.14f;
		
		// 실수 타입 최소, 최대값
		System.out.println("float : " + Float.MIN_VALUE + " ~ " + Float.MAX_VALUE);
		System.out.println("double : " + Double.MIN_VALUE + " ~ " + Double.MAX_VALUE);
		
		float number4 = 1.23456789f;
		double number5 = 1.23456789;
		
		System.out.println(number4);
		System.out.println(number5);
		//float , double은 저장할수있는 값의 크기만이 아니라
		//소숫점 이하 정밀도의 차이가 이다
		
		
	} // end main

} // end class






