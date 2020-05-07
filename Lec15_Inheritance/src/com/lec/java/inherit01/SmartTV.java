package com.lec.java.inherit01;

public class SmartTV {
	//멤버변수
	boolean isPowerOn;
	int channel=0;
	int volume=0;
	String ip="";  //SmartTv에 새로 추가된 필드
	 
	public void displayInfo() {
		System.out.println("=====  tv 현재상태  =====");
		System.out.println("전원 : "+isPowerOn);
		System.out.println("채널 : "+channel);
		System.out.println("볼륨 : "+volume);
		System.out.println("IP주소 : "+ip);
		
	}
}
