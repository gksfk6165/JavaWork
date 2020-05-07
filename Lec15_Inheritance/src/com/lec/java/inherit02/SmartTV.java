package com.lec.java.inherit02;

public class SmartTV extends BasicTV{
	String ip;
	
	public void displayInfo() {
		super.displayInfo();
		System.out.println("ip주소");
	}
}
