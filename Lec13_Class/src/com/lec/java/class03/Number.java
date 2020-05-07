package com.lec.java.class03;

public class Number {
	// getter: 멤버 변수의 값을 리턴해 주는 메소드
	// setter: 멤버 변수의 값을 변경해 줄 수 있는 메소드

	private int num=0;
	private char ch;
	
	public Number() {
		
	}
	public Number(int num,char ch) {
		this.num=num;
		this.ch=ch;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		if(num>=0) {
			this.num = num;
		}
	}
	public char getCh() {
		return ch;
	}
	public void setCh(char ch) {
		this.ch = ch;
	}
}
