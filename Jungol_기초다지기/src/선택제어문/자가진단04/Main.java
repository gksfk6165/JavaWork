package 선택제어문.자가진단04;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		float kg = 0;
		kg = sc.nextFloat();

		if (kg<=50.80) {
			System.out.println("Flyweight");
		} else if(kg>50.80 &&kg<=61.23){
			System.out.println("Lightweight");
		} else if(kg>61.23 &&kg<=72.57) {
			System.out.println("Middleweight");
		}else if(kg>72.57 &&kg<=88.45) {
			System.out.println("Cruiserweight");
		}
		else if(kg>88.45) {
			System.out.println("Heavyweight");
		}
		
	}
}
