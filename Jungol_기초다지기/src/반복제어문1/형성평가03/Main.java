package 반복제어문1.형성평가03;

import java.util.Scanner;

//55 100 48 36 0 101
//sum : 239
//avg : 47.8

public class Main {
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		int num=0;
		int sum=0;
		int count=0;
		double avg;
		
		while (true) {
			num=sc.nextInt();
			sum+=num;
			count++;
			
			if(num>100) {
				sum=sum-num;
				System.out.println(count+"//"+sum);
				avg=((double)sum/(count-1));
				break;
			}
			
		}
		System.out.println("sum : "+sum);
		System.out.println("avg : "+String.format("%.01f", avg));
		
	}
}
