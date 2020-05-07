package 선택제어문.자가진단08;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		float avg = sc.nextFloat();

		switch ((int)avg) {
		case 4:
			System.out.println("scholarship");
			break;
		case 3:
			System.out.println("next semester");
			break;
		case 2:
			System.out.println("seasonal semester");
			break;

		default:
			System.out.println("retake");
			break;
		}
	}
}
