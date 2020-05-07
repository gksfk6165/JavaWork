package com.lec.java.inherit04;

public class Vehicle {
	int speed;
	
	public Vehicle() {
		System.out.println("Vehicle생성자");
	}
	public Vehicle(int speed) {
		this.speed=speed;
		System.out.println("Vehicle(int) speed "+speed);
	}
}
