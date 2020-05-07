package com.lec.java.for04;

public class For04Main {

	public static void main(String[] args) {
		System.out.println("for문 연습");
		
		//1~100 2,7 공배수만 출력
		
		for (int i = 1; i <= 100; i++) {
			if(i%14==0) {
				System.out.println(i);
			}
				
		}
		System.out.println("======================");
		//1부터 10ㄲ지의 합
		int sum=0;
		for (int i = 1; i < 11; i++) {
			sum=sum+i;
			
		}
		System.out.println(sum);
	} // end main ()

} // end class For04Main










