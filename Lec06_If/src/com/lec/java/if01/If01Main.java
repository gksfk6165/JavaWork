package com.lec.java.if01;

/* if, if ~ else 조건문
 * 
 * 구문1:
 * 	if (조건식) {
 *  	조건식이 true 일때 실행되는 문장(들) 
 *  	...
 * 	}
 * 
 * 구문2:
 *  if (조건식) {
 *		조건식이 true 일때 실행되는 문장(들)
 *		...
 *  } else {
 *		조건식이 false 일때 실행되는 문장(들)
 *		...
 *  }
 */
public class If01Main {

	public static void main(String[] args) {
		System.out.println("if 조건문");

		int num = -10;

		if (num < 0) {
			System.out.println("음수입니다.");
		}

		if (num > 0) {
			System.out.println("양수입니다.");
		} else {
			System.out.println("양수가아닙니다.");
		}

		if (num < 0)
			System.out.println(num + " 음수");
		else
			System.out.println(num + " 0 또는양수");

		// 주어진 숫자 짝수홀수여부
		int num3 = 124;

		if (num3 % 2 == 0) {
			System.out.println("짝수");
		} else {
			System.out.println("홀수");
		}
		
		//주어진 숫자가 0~100점까지범위인지여부인지
		int num4=40;
		if (num4>=0 && num4<=100) {
			System.out.println("유효한정수");
		} else {
			System.out.println("범위를벗어낫습니다");
		}

		System.out.println("\n프로그램 종료");
	} // end main()

} // end class
