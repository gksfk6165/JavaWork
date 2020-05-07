package 배열1.자가진단09;

import java.util.Scanner;

//95 100 88 65 76 89 58 93 77 99
public class Main {
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		int [] num=new int[10];
		int sort=0;
		
		for (int i = 0; i < num.length; i++) {
			num[i]=sc.nextInt();
		}
		
		for (int i = 0; i < num.length; i++) {
			
			for (int j = 0; j < num.length-1; j++) {
				
				if(num[j]<num[j+1]) {
					sort=num[j];
					num[j]=num[j+1];
					num[j+1]=sort;
				}
			}
		}
		for (int j2 = 0; j2 < num.length; j2++) {
			System.out.println(num[j2]);
		}
	}
}