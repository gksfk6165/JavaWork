package practice.stddev;

import java.util.Scanner;

public class StdDev {
	static double userAvg;   //평균값
	static double userVariance;  //분산값
	static double userStandardDeviation;  //표준편차
	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		int []userInput=new int[5];
		userAvg=0.0;  
		userVariance=0.0;
		userStandardDeviation=0.0;
		for (int i = 0; i < userInput.length; i++) {
			userInput[i]=sc.nextInt();
		}
		userAvg=calcAvg(userInput);  //평균값 받아오기
		userVariance=calcVariance(userInput);//분산값 받아오기
		userStandardDeviation=calcStdDev(userInput);
		
		System.out.println("평균: "+userAvg);
		System.out.println("분산: "+userVariance);
		System.out.println("표준편차: "+userStandardDeviation);

	} // end main
	public static double calcAvg(int [] userScore) {
		double avg=0.0;
		double sum=0.0;
		for (int i = 0; i < userScore.length; i++) {
			sum=sum+userScore[i];
		}
		avg=sum/userScore.length;
		return avg;
	} //end calcAvg(int[])

	public static double calcVariance(int [] userScore) {
		double variance=0.0;   //분산값
		double [] deviation=new double[userScore.length];
		double miusDeviation=0.0;  //변량-평균
		double sum=0.0;
		//편차를 구해야 분산을 구할수있다.
		
		for (int i = 0; i < userScore.length; i++) {
			miusDeviation=userScore[i]-userAvg;
			deviation[i]=miusDeviation;
		
			sum=sum+(deviation[i]*deviation[i]);
		}
		variance=sum/userScore.length;
		
		
		return variance;
	}
	
	public static double calcStdDev(int [] userScore) {
		double stDeviation=0.0;
		
		stDeviation=Math.sqrt(userVariance);
		
		return stDeviation;
	}

} // end class
