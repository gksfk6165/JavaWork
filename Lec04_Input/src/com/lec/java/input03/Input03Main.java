package com.lec.java.input03;

import java.util.Scanner;

public class Input03Main {
	public static void main(String[] args) {
		System.out.println("netxLine() vs next()");
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("여러 단어의 문장을 입력");
		String line= sc.nextLine();    // 엔터칠때까지
		System.out.println("line :  "+line);
		
		//next()
		//다음 단어(token) 받아서 String 으로 결과 리턴
		System.out.print("");
		String token1 = sc.next();
		System.out.println(token1);
		String token2=sc.next();
		System.out.println(token1);
		String token3=sc.next();
				
		System.out.println(token1);
		System.out.println(token2);
		System.out.println(token3);
		
		//숫자타입도 여래개 한줄로입력받기가능
		System.out.println("int  double   int  입력:");
		int i1=sc.nextInt();
		double d1=sc.nextDouble();
		int i2=sc.nextInt();
		
		
		sc.close();
	
	}
}
