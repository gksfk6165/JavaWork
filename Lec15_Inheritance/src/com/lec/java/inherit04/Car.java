package com.lec.java.inherit04;

public class Car extends Vehicle {

	int oil;
	//1
	public Car() {
		// 부모클래스의 기본생성자 호출-->Vehicle();
		// 명시적으로 super 생성ㅈ가 없으면 부모의 기본 생성자를호출함

		System.out.println("car생성자");
	}
	//2
	public Car(int oil) {
		//super()는 반드시 생성자 코드의 첫번쨰 
		super(); // 부모의 기본생성자를 호출
		this.oil=oil;
		System.out.println("Car(int oil) oil: " + oil);
	}
	//3
	public Car(int speed, int oil) {
		super(speed); // 부모의 생성자중 매개변수 int 타입인것을 호출
		this.oil=oil;
		System.out.println("Car(int oil) oil: " + oil+" 스피드: "+speed);
	}
	public Car(double value) {
		this(555,(int)value);
		System.out.println("car(double) : value : "+value);
	}
}
