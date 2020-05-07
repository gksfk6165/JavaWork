package com.lec.java.array11;

/* for와 enhanced for의 차이점
	 enhanced for문에서는 배열의 원소를 꺼내서
	 변수에 복사(저장)해서 사용하는 것입니다.
	 즉, 배열의 원소를 직접 변경하는 것은 불가능하다.
 */
public class Array11Main {

	public static void main(String[] args) {
		System.out.println("for와 enhanced for의 차이점");
		
		int [] arr1= {10,20,30,40,50};
		
		
		System.out.println("증가전 ");
		for (int i = 0; i < arr1.length; i++) {
			System.out.print(arr1[i]);
		}
		System.out.println("\n\n증가후");
		for (int i = 0; i < arr1.length; i++) {
			arr1[i]++;
			System.out.print(arr1[i]);
		}
		
		System.out.println("\n\nenhanced for 증가후");
		int [] arr2= {1,2,3,4,5};
		for (int num:arr2) {
			num++;
		}
		for(int num:arr2){
			System.out.println(num);
		}
		//사본이기때문에 바뀌지않는다. 
		
	} // end main()

} // end class Array11Main









