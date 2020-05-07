package 선택제어문.자가진단05;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		float f1 =sc.nextFloat();
		float f2= sc.nextFloat();
		
		

		if (f1 >= 4.0 && f2 >= 4.0) {
			System.out.println("A");
		} else if(f1 >= 3.0 && f2 >= 3.0){
			System.out.println("B");
		}else {
			System.out.println("C");
		}
	}
}
