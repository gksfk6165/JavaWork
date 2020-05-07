package com.lec.java.lambda03;

/*
	 세가지 방법으로 자유자재로 구현할수 있어야 합니다.
	 방법 1) 클래스 implements 인터페이스 + 오버라이딩.
	 방법 2) 익명클래스
	 방법 3) 람다 표현식 lambda expression
*/
public class Lambda03Main {

	public static void main(String[] args) {
		System.out.println("익명 클래스, 람다 표현식 연습");
		
	//방법1 클래스 imple 인터페이스+오버라이딩
	//덧셈	
	Operable t1=new Add();
	t1.operate(10, 10);
	System.out.println(t1.operate(10, 10));	
	//방법2 익명클래스
	//뺄셈	
	Operable t2 =new Operable() {
		
		@Override
		public double operate(double x, double y) {
			// TODO Auto-generated method stub
			return x-y;
		}
	};
	System.out.println(t2.operate(10, 5));
		
	//람다표현식 
	//제곱
	Operable t3=(x,y) -> Math.pow(x, y);
	t3.operate(2, 3);
	System.out.println(t3.operate(2, 3));
	
		
	System.out.println("\n프로그램 종료");
	} // end main()
	
} // end class
interface Operable{
	public abstract double operate(double x,double y); 
}
class Add implements Operable {

	@Override
	public double operate(double x, double y) {
		// TODO Auto-generated method stub
		return x+y;
	}
}

