package com.lec.java.inner03;

public class TestOuter {
	private int value;
	
	public TestOuter(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
	public class TestInner{
		private int value;
		
		public TestInner(int value) {
			this.value=value;
		}
		public void printValue() {
			int value=10;
			System.out.println(value);
			System.out.println(this.value);
			System.out.println(TestOuter.this.value);
		}
	}

} // end class TestOuter














