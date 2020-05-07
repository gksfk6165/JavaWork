package com.lec.java.collection04;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Collection04Main {

	public static void main(String[] args) {
		System.out.println("ArrayList 연습");
		Scanner sc=new Scanner(System.in);
		ArrayList<MemberModel> mem =new ArrayList<MemberModel>();
		
		
		for (int i = 0; i < 3; i++) {
			MemberModel memModel=new MemberModel();
			String id=sc.nextLine();
			memModel.setId(id);
			String pass=sc.nextLine();
			memModel.setPasswd(pass);
			mem.add(memModel);
		}
		
		for (int i = 0; i < 3; i++) {
			mem.get(i).displayInfo();;
		}
		System.out.println("-------------");
		for (MemberModel e:mem) {
			e.displayInfo();
		}
		System.out.println("-------------");
		Iterator<MemberModel> itr = mem.iterator();
		
		while(itr.hasNext()) {
			itr.next().displayInfo();
		}
		sc.close();
		System.out.println("\n프로그램 종료");
	} // end main()

} // end class












