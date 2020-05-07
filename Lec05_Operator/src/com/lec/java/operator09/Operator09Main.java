package com.lec.java.operator09;

/* 산술 연산의 결과 타입
 * 
 * 일단 피연산자가 reference type 이면, unbox 후 형변환 수행됨. 그리고 나서
 * 피연산자중 하나라도 double 이면 다른쪽이 double 이 된다.  
 * 그렇지 않으면 피연산자중 하나라도 float 이면 다른 쪽이 float 가 된다.  
 * 그도 아니면 피연산자중 하나라도 long 이면 다른 쪽을 long 으로 바꾼다.  
 * 그도 아니면 양쪽 피연산자 모~ 두 int 로 바꾼다.

 */
public class Operator09Main {

	public static void main(String[] args) {
		System.out.println("산술연산의 결과 타입");

		int n1 = 10, n2 = 20;
		int n3 = n1 + n2;
		System.out.println(n3);

		byte b1 = 10, b2 = 20;
		// byte+byte->int

		long lo1 = 10L;
		//int n4 = n1 + lo1; // int+long->long
		// TODO
		
		float f1 = 1.0f, f2 = 2.0f;
		float f3 = f1 + f2;   // OK  
		f3 = f1 + n1;  
		f3 = f1 + b1;
		
		double d1 = 1.0, d2 = 2.0;
		double d3 = d1 + d2;
		d3 = d1 + f1;
		
		long l2=27000000000L;
		System.out.println(l2);
		
		l2=3000*3000*3000;
		
		System.out.println(l2);
		
		//복합대입연산자
		int sum=0;
		double d4=1.2;
		sum+=d4;
		//복합대입연산자는
		//sum=sum+d4가 아니라
		//sum=(int)(sum+d4)이렇게동작하기때문에 에러나지않음
		System.out.println(sum);

		System.out.println("\n 프로그램 종료");
	} // end main ()

} // end class