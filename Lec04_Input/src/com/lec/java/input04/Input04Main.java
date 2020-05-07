package com.lec.java.input04;

import java.util.Scanner;

//일반적으로 프로그램에서 숫자입력하는 것이 처음에는 '문자열(String)' 형태다
//ex) 웹, 모바일앱..
//
//이를 숫자 타입으로 변환해야 산술 연산등이 가능해진다
//
//Integer.parseInt(문자열)  -->  int 로 변환
//Double.parseDouble(문자열)  --> double 로 변환

//Byte.parseByte(문자열)
//Short.parseShort(문자열)
//Long.parseLong(문자열)
//Float.parseFloat(문자열)
//Boolean.parseBoolean(문자열)

//문자열이 해당 타입으로 변환할수 없는 문자열이면 NumberFormatException 예외 발생 (에러)

public class Input04Main {
	public static void main(String[] args) {
		
		
		Scanner sc=new Scanner(System.in);
		
		String l11 =sc.next();
		int l1=Integer.parseInt(l11);
		int l2=Integer.parseInt(sc.next());
		int l3=Integer.parseInt(sc.next());
		
		System.out.println(l1+l2+l3);
		
		double d1=Double.parseDouble(sc.next());
		double d2=Double.parseDouble(sc.next());
		double d3=Double.parseDouble(sc.next());
		
		System.out.println(d1+d2+d3);
		
		sc.close();
		
	}//end main()
}//end class
