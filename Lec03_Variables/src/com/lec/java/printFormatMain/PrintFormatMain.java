package com.lec.java.printFormatMain;


/* 서식화된 문자열 (formatted string)
 *  ● 화면에 출력할때는 -> printf()
 *    
 *    printf("서식문자열", 값1, 값2....)
 *    
 *  ● 문자열(String)으로 만들때는 -> String.format()
 *       	
 *    String.format("서식문자열", 값1, 값2....)
 *    
 *  ● format specifier (서식 지정자)
 *  	%d  :  십진수 정수로 출력
 *  	%f  :  실수 출력
 *  	%s  :  문자열 출력
 *  	%c  :  '문자하나' 출력
 *  	%x  :  16진수 정수로 출력
 *  	%%  :  % 출력
*/


public class PrintFormatMain {
	public static void main(String[] args) {
		System.out.println("서식화된 출력: printf(), String.format()");
		
		double pi = Math.PI;  // 원주율 값
		System.out.println(pi);
		
		//printf
		
		System.out.printf("원주율 %f\n ",pi);
		System.out.printf("원주율 %.2f\n",pi);
		
		
		int age =10;
		short grade = 3;
		
		
		System.out.printf("제나이는 %d, 학년은 %d학년입니다.",age, grade);
		
		//소숫점 이하 제한
		double height= 182.3;
		System.out.printf("저는 %d살입니다.키는%fcm입니다\n",age,height);
		System.out.printf("저는 %d살입니다.키는%.1fcm입니다\n",age,height);
		
		// 출력폭 지정, 좌우 정렬
		System.out.printf("|%d|%d|%d|\n",100,200,300);
		System.out.printf("|%5d|%5d|%5d|\n",100,200,300); //우측정렬기본
		System.out.printf("|%-5d|%-5d|%-5d|\n",100,200,300); //우측정렬기본
		
		System.out.printf("제이름은[%10s]입니다. 혈액형은 %c 입니다.\n","봉준호",'c');
		
		//%출력
		double rate = 134423.0 / 345678.0;
		
		System.out.printf("합격률은은 %.1f%%입니다\n",rate);
		
		//format 문자열을 따로 설정해서 운영
		String fmt="주소 : %s,우편번호[%05d]";
		System.out.printf(fmt+"\n","서울",12345);
		System.out.printf(fmt+"\n","대구",12345);
		System.out.printf(fmt+"\n","부산",12345);
		
		String.format("합격률은은 %.1f%%입니다\n", rate);
		String result = String.format("합격률은은 %.1f%%입니다\n", rate);
		System.out.println(result);
		
		//숫자에패딩
		System.out.printf("|%05d|%05d|%05d\n",100,200,300);
	}
}
