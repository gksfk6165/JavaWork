package com.lec.java.class02;

public class Rectangle {
	//속성 메버변수
	//가로,세로
	
	double width;
	double height;
	
	//생성자 - 멤버변수초기화
	//1 디폴트 생성ㅈ
	public Rectangle() {
		System.out.println("Rectangle()생성");
		System.out.println(width);
		System.out.println(height);
	}
	
	
	
	//2 매개변수 가진 생성자
	public Rectangle(double w,double h) {
		width=w;
		height=h;
		System.out.println("Rectangle(double w,double h)");
		System.out.println(width);
		System.out.println(height);
	}
	public double calcPerimeter() {
		
		
		return (width+height)*2;
	}
	public double calcArea() {
		
		return width*height;
	}
	//동작:멤버메소드
}
