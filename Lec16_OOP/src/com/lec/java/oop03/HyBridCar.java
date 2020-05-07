package com.lec.java.oop03;

public class HyBridCar extends Car{

	private int electricity;

	public int getElectricity() {
		return electricity;
	}

	public void setElectricity(int electricity) {
		this.electricity = electricity;
	}
	
	@Override
	public void displayInfo() {
		System.out.println("==========하이브리드카정보===========");
		System.out.println("speed: "+getSpeed());
		System.out.println("oil: "+getOil());
		System.out.println("electricity: "+electricity);
	}
	
}
