package 반복제어문1.자가진단04;

import java.util.Scanner;


public class Main {
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		
		int num=0;
		int sum=0;
		int count=0;
		double avg;
		
		while (true) {
			num=sc.nextInt();
			sum+=num;
			count++;
			
			if(num>=100) {
				avg=(double)sum/count;
				break;
			}
			
		}
		sc.close();
		System.out.println(sum);
		System.out.println(avg);
		
	}
}
