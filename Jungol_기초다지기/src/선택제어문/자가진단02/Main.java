package 선택제어문.자가진단02;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		int overkg=0;
		int cm=sc.nextInt();
		int kg=sc.nextInt();
		
		
		overkg=kg+100-cm;
		
		if(overkg>0) {
			System.out.println(overkg);
			System.out.println("Obesity");
		}else {
			System.out.println(overkg);
		}
	}
}
