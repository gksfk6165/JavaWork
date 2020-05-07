package com.lec.java.for02;

import java.util.Scanner;

public class For02Main {

	public static void main(String[] args) {
		System.out.println("For문 - 구구단 출력");
		
		System.out.println("구구단 출력");
		
		Scanner sc =new Scanner(System.in);
		
		System.out.println("몇단?");
		int gugudan=sc.nextInt();
		
		
		for (int i = 1; i < 10; i++) {
			System.out.println(gugudan*i);
		}

	} // end main()

} // end class For02Main












