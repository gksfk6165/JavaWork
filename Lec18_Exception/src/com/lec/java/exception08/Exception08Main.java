package com.lec.java.exception08;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exception08Main {

	static Scanner sc = new Scanner(System.in);
	
	// TODO : AgeInputException 을 throws 하는 메소드 정의
	public static int inputAge() throws AgeInputException{
		System.out.println("나이 입력:");
		int age = sc.nextInt();

		if(age < 0) {
			AgeInputException ex=new AgeInputException(age+" 나이가 0보다 적을순 없습니다");
			throw ex;
		}
		return age;
		
	} // end inputAge()
	
	
	public static void main(String[] args) {
		System.out.println("예외 클래스 만들기 2");
		int i=0;
		while (i<5) {
			try {			
				int age = inputAge();
				System.out.println("나이는 = " + age);
				i++;
			}catch (AgeInputException ex) {
				System.out.println(ex.getMessage());
			}catch(InputMismatchException misEx){
				System.out.println("적절하지않은 입력값입니다");
				sc.nextLine();
			}
		}
		
		
		System.out.println("프로그램 종료...");
		
	} // end main()

} // end class Exception08Main












