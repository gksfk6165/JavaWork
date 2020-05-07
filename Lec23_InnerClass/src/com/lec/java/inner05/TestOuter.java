package com.lec.java.inner05;

public class TestOuter {
	// TestOuter 클래스의 멤버 변수
	private int num1 = 100;
	
	// TestOuter 클래스의 멤버 메소드
	public void localMethod(int num4) {
		int num2=200;
		//num4=700;
		//로컬 이너 클래스
		class TestLocal{
			//멤버변수
			private int num3=300;
			
			
			//멤버 매소드
			public void showNumbers() {
				System.out.println(num1); //외부클래스의 멤버
				System.out.println(num2); //class와같은 로컬 지역변수
				System.out.println(num3); //자기자신
				System.out.println(num4);
			}
			
		}
		TestLocal local=new TestLocal();
		local.showNumbers();
		
	} // end localMethod()
	

} // end class TestOuter













