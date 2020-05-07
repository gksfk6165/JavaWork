package practice.game369;

import java.util.Scanner;

public class Game369 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		
//		String three="3";
//		String six="6";
//		String nine="9";
		// 문자열변환 이용하지말것..
		
		int num369 = 100;
		int count = 0;
		// int length = 0;

		for (int i = 1; i <= num369; i++) {
			count++;
			
			//1~9 11~19 .. 91~99
			if (i % 10 != 0) {  
				if (count % 10 == 3 || count % 10 == 6 || count % 10 == 9 || count / 10 == 3 || count / 10 == 6
						|| count / 10 == 9) {
					System.out.print("*\t");
				} else {
					System.out.print(i + "\t");

				}
			} else {   //10 20 30 ~ 100 
				if (count / 10 == 3 || count / 10 == 6 || count / 10 == 9) {
					System.out.println("*");
				} else {
					System.out.println(i);
				}
			}
		}
	}
}
