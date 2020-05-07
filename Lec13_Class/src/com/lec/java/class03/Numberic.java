package com.lec.java.class03;

public class Numberic {
	private char ch;
	private byte operator;
	private int operand1;
	private int coperand2;
	
	public Numberic() {
		
	}
	public Numberic(char ch,byte operator,int operand1,int coperand2) {
		this.ch=ch;
		this.operator=operator;
		this.operand1=operand1;
		this.coperand2=coperand2;
	}
	public char getCh() {
		return ch;
	}
	public void setCh(char ch) {
		this.ch = ch;
	}
	public byte getOperator() {
		return operator;
	}
	public void setOperator(byte operator) {
		this.operator = operator;
	}
	public int getOperand1() {
		return operand1;
	}
	public void setOperand1(int operand1) {
		this.operand1 = operand1;
	}
	public int getCoperand2() {
		return coperand2;
	}
	public void setCoperand2(int coperand2) {
		this.coperand2 = coperand2;
	}
}
