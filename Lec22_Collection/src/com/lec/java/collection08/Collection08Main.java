package com.lec.java.collection08;

import java.util.HashSet;
import java.util.Iterator;
//Set 에서 같은지 다른지, 식별 가능하려면
//hashCode 와 equals 가 오버라이딩 되어야 한다
//hashCode() 값이 같고 equals() 결과가 true 이어야만 같은 객체로 판정한다.

public class Collection08Main {

	public static void main(String[] args) {
		System.out.println("HashSet 연습");
		
		// MyClass 타입을 저장할 수 있는 HashSet 인스턴스 생성
		// 데이터 3개 이상 저장해보고 iterator, enahnce-for 등을 
		// 사용하여 출력해보기
		HashSet<MyClass> set=new HashSet<MyClass>();
		MyClass mc1=new MyClass();
		MyClass mc2=new MyClass();
		MyClass mc3=new MyClass();
		mc1.setId(120312);
		mc1.setName("KIM");
		mc2.setId(220312);
		mc2.setName("이");
		mc3.setId(120312);
		mc3.setName("kim");
		set.add(mc1);
		set.add(mc2);
		set.add(mc3);
		System.out.println(set.size());
		
		Iterator<MyClass> itr=set.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next().toString());
		}
		
		// 검색: Iterator, enhanced for
		System.out.println();
		System.out.println("Iterator");
		// TODO
		
		System.out.println();
		System.out.println("enhanced for");
		// TODO			

		// forEach() 메소드 사용
		System.out.println();
		System.out.println("forEach() 사용");
		// TODO

		System.out.println("\n프로그램 종료");
	} // end main()
} // end class

