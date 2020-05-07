package com.lec.java.dowhile04;
/*
	do {
		...
		...
	}while(조건식) 문인 경우에는,
	
	{...} 안에 있는 실행문들을 한번은 실행을 하고 나서
	조건식을 검사하게 된다.

*/

public class While04Main {

	public static void main(String[] args) {
		System.out.println("do~while문 연습");
		
		int n =0;
		while (n>0) {
			System.out.println(n);
			n--;
		}
		n=0;
		System.err.println("----------------------");
		do {
			System.out.println(n);
			n--;
		} while (n>0);
		
		System.err.println("----------------------");
		//구구단 9단 두와일로
		n=1;
		do {
			System.out.println(n*9);
			n++;
		} while (n<10);
		
	} // end main()

} // end class While04Main









