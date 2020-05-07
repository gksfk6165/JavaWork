package com.lec.java.collection02;

import java.util.ArrayList;
import java.util.Iterator;

import com.lec.java.collection03.Student;

public class Collection02Main {

	public static void main(String[] args) {
		System.out.println("ArrayList 연습");
		//TODO:
		// String 타입을 담는 ArrayList를 만들고
		// 5개 이상의 String을 저장하고
		// set(), remove() 등의 메소드 사용하여
		// 임의의 것을 수정, 삭제 도 해보시고
		// 3가지 방식으로 출력해보세요
		//  for, Enhanced-for, Iterator

		ArrayList<String> st1=new ArrayList<String>();
		Student student=new Student();

		System.out.println(st1);
		
		st1.set(2, "수정!");
		//st1.remove(1); //지우기
		//st1.clear();//초기화
		
		for(String e : st1) {
			System.out.println(e);
		}
		
		Iterator<String> itr = st1.iterator();
		
		System.out.println("==================");
		
		// hasNext(): iterator가 다음 원소를 가지고 있는 지(true/false)
		// next(): 현재 iterator 위치의 원소를 값을 리턴하고,
		//   iterator의 위치를 다음 원소의 위치로 변경
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		
		System.out.println("\n프로그램 종료");
	} // end main()

} // end class












