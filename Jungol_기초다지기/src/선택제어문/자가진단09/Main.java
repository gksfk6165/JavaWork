package 선택제어문.자가진단09;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n1=0;
		int n2=0;
		int n3=0;
		
		int min=0;
		
		n1=sc.nextInt();
		n2=sc.nextInt();
		n3=sc.nextInt();
		min =(n1 < n2) ? n1 : n2; 
		min = (min < n3) ? min : n3;
		
		System.out.println(min);
	}
}
