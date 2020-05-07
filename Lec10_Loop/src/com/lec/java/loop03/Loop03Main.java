package com.lec.java.loop03;

public class Loop03Main {

	public static void main(String[] args) {
		System.out.println("중첩 for 문 nested for");

		// 구구단 출력 : 중첩 for 사용
		// TODO
//		for (int i = 2; i < 10; i++) {
//			System.out.println(i+"단");
//			for (int j = 1; j < 10; j++) {
//				System.out.println(i*j);
//			}
//			System.out.println();
//		}
		
		System.out.println();
		// 구구단 출력 : 중첩 while 문 사용
		// TODO
		
		int gugu=2;
		int num=1;
		while (gugu<10) {
			
			while (num<10) {
				System.out.println(gugu*num);
				num++;
			}
			num=1;
			gugu++;
			
//			for (int i = 1; i < 10; i++) {
//				System.out.println(gugu*i);
//			}
//			System.out.println();
//			gugu++;
//			
//			if(gugu>9) break;s
		}
		
		
		
		System.out.println("\n프로그램 종료");
	} // end main()

} // end class


















