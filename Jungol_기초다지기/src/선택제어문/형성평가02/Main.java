package 선택제어문.형성평가02;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n1 = sc.nextInt();
		if (n1 ==0) {
			System.out.println("zero");
		} else if(n1>0){
			System.out.println("plus");
		}else {
			System.out.println("minus");
		}

	}
}
