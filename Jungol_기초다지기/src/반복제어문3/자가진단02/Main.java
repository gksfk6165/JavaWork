package 반복제어문3.자가진단02;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner scanner=new Scanner(System.in);
		
		int num=0;
		num=scanner.nextInt();
		for (int i = 1; i <= num; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
	}
}
