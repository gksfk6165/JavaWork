package com.lec.java.array04;

import java.util.Scanner;

/* 연습
 * 길이 5개 int 형 배열을 선언하고
 * 사용자로부터 5개 정수를 입력받아 초기화 한뒤 
 * 
 * 총점, 평균, 최대값, 최소값  출력해보기
 */
public class Array04Main {

	public static void main(String[] args) {
		System.out.println("배열 연습");

		Scanner sc = new Scanner(System.in);

		int user = 0;
		int total = 0;
		double avg = 0;
		int maxValue = 0;
		int minValue = 0;

		int[] num = new int[5];
		for (int i = 0; i < num.length; i++) {
			user = sc.nextInt();
			num[i] = user;
			total = total + num[i];
		}
		avg = (double) total / num.length;

		maxValue = num[0];
		minValue = num[0];
		for (int i = 0; i < num.length; i++) {
			if (maxValue < num[i]) {
				maxValue = num[i];
			}
		}
		for (int i = 0; i < num.length; i++) {
			if (minValue > num[i]) {
				minValue = num[i];
			}
		}
		System.out.println(total + " 총점");
		System.out.println(avg + " 평균");
		System.out.println(maxValue + " 최대값");
		System.out.println(minValue + " 최소값");

	} // end main()

} // end class Array04Main
