package com.lec.java.collection03;

import java.util.ArrayList;
import java.util.Scanner;

public class Collection03Main {

	public static void main(String[] args) {
		System.out.println("ArrayList 연습");
		Scanner sc=new Scanner(System.in);
		//TODO:
		// Student 타입을 담는 ArrayList를 만드고
		// 사용자로부터 3개의 Student 데이터 을 입력받아서
		// 3가지 방법으로 출력해보세요. 
		// for, Enhanced-for, Iterator
		ArrayList<Student> stu=new ArrayList<Student>();
		Student student=new Student();
		Score score=new Score();
		for (int i = 0; i <1; i++) {
			student.setId(i);
			student.setName(sc.next());
			score.setKorean(sc.nextInt());
			score.setEnglish(sc.nextInt());
			score.setMath(sc.nextInt());
			student.setScore(score);
			stu.add(student);
		}
		for (Student e:stu) {
			System.out.println(e);
		}
		
		
		System.out.println("\n프로그램 종료");
	} // end main()

} // end class









