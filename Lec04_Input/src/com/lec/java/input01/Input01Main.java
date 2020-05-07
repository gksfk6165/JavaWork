package com.lec.java.input01;

import java.util.Scanner;

public class Input01Main {
	public static void main(String[] args) {
		System.out.println("표준입력 : 스캐너사용");
		
		Scanner input=new Scanner(System.in);   // import 필요 , 스캐너객체 생성
		
		//스캐너 사용한 입력작업
		int num1,num2;
		System.out.println("1 .입력하세요");
		num1=input.nextInt();
		System.out.println("2 .입력하세요");
		num2=input.nextInt();
		System.out.println(num1+" + "+num2+" = " +(num1+num2));
		
		//nextInt()   문자나 다른걸 이력하면 예외발생
		// 각 primitive 타입에 대해 nextXXX() 메소드 제공
//		sc.nextByte();
//		sc.nextShort();
//		sc.nextLong();
//		sc.nextFloat();
//		sc.nextDouble();
//		sc.nextBoolean();
		
		input.close();
	}
}
