package com.lec.java.class02;


public class Class02Main {

	public static void main(String[] args) {
		System.out.println("클래스 연습");		
		
		Circle c1=new Circle(); //생성자에목적. 멤버변수의초기화
		
		Circle c2=new Circle(3);
		
		double perimeter=c1.calcPerimeter();
		System.out.println("c1으둘레  "+perimeter);
		perimeter=c2.calcPerimeter();
		System.out.println("c2으둘레  "+perimeter);
		
		System.out.println("c1의넓이  "+c1.calcArea());
		System.out.println("c1의넓이  "+c2.calcArea());
		
		System.out.println();
		Rectangle r1=new Rectangle();
		Rectangle r2=new Rectangle(2,3);
		
		r1.calcArea();
		r2.calcPerimeter();
		
		
		System.out.println("프로그램 종료");
	} // end main()

} // end class Class02Main










