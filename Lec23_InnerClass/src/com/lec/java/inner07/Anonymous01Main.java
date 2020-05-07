package com.lec.java.inner07;


/*
  Anonymous inner class(익명 내부 클래스):
   이름이 없는 local inner class
   이름이 없기 때문에 생성자를 만들 수가 없습니다.
   클래스의 정의와 동시에 인스턴스를 생성합니다.
*/
public class Anonymous01Main {

	public static void main(String[] args) {
		System.out.println("Anonymous Inner Class(익명 내부 클래스)");
		Person p=new Person("헐크");
		Readable r = p.createInstance(55);
		r.readInfo();
		
		Readable r2 = new Readable() {
			@Override
			public void readInfo() {
				System.out.println("r2 의 readInfo 입니다");				
			}
		};
		r2.readInfo();
		
		Readable r3=new Readable() {
			@Override
			public void readInfo() {
				System.out.println("r3");
			}
		};
		r3.readInfo();
		
		new Readable() {
			@Override
			public void readInfo() {
				// TODO Auto-generated method stub
				System.out.println("따끈");
			}
		}.readInfo();
		
		Movable m1=new Movable() {
			
			@Override
			public void move(int times) {
				System.out.println(times*speed);
			}
		};
		m1.move(2);
		m1.move(10);
	}
	


} // end class Anonymous01Main

abstract class Movale{
	int speed=100;
	public abstract void move(int times);
}














