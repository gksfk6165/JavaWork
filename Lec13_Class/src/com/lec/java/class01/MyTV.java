package com.lec.java.class01;
/*
클래스:
우리가 만들고자 하는 대상의 '상태' 와 '기능' 을 함께 가지고 있는 '데이터 타입'
상태(속성, 필드) -> 클래스의 멤버변수로 정의 
    field, attribute, member variable 라고 함
기능(동작) -> 클래스의 멤버메소드로 정의  
    behavior, member method 라고 함


일반적으로 
 멤버변수(필드)는 private 으로 설정. 
 멤버메소드는 public 으로 설정.
*/


public class MyTV {
	//TV의상태(속성) --멤버변수
	boolean isPowerOn;//전원이 on/off
	int channel=0;//현재채널
	int volume=0;//현재볼륨
	
	//TV의기능(동작) --멤버메소드
	//현재상태표시
	public void displayStatus() {
		System.out.println("TV현재상태");
		System.out.println("------------------");
		System.out.println("전원상태 : "+isPowerOn);  //동일 클래스 안의 멤버들 서로 사용가능
		System.out.println("채널 : "+channel);  //동일 클래스 안의 멤버들 서로 사용가능
		System.out.println("볼륨 : "+volume);  //동일 클래스 안의 멤버들 서로 사용가능
		System.out.println("------------------");
	}
	//전원토글동작
	public void powerOnOff() {
		if(isPowerOn) {
			isPowerOn=false;
			System.out.println("TV를 끕니다.");
		}else {
			isPowerOn=true;
			System.out.println("TV를 켭니다");
		}
	}
	//채널+동작
	public int channelUp() {
		channel++;
		System.out.println("현재채널: "+channel);
		return channel;
	}
	//채널-동작
	public int channelDown() {
		channel--;
		System.out.println("현재채널: "+channel);
		return channel;
	}
	//볼륨+동작
	public int volumeUp() {
		volume++;
		System.out.println("현재볼륨: "+volume);
		return channel;
	}
	//볼륨-동작
	public int volumeDown() {
		volume--;
		System.out.println("현재볼륨: "+volume);
		return volume;
	}
}
