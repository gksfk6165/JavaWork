package com.lec.java.inherit07;

public class BuinessPerson extends Person{
	public String company;

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}
	
	//매소드 오버로딩
	public void showInfo(int id) {
		System.out.println("id : "+id);
		showInfo();
	}
	
	@Override  //매소드 재정의
	public void showInfo() {
		// TODO Auto-generated method stub
		super.showInfo();
		System.out.println("회사"+company );
	}
}
