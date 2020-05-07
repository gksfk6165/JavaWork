package com.lec.java.array02;
/*  배열의 선언과 초기화
 	
 	배열 선언 따로, 초기화 따로
		타입[] 이름 = new 타입[배열의 길이];
		
	배열을 선언과 동시에 초기화 1
		타입[] 이름 = new 타입[] {a, b, c, ...};
		
	배열을 선언과 동시에 초기화 2
		타입[] 이름 = {a, b, c, ...};
		
	배열의 길이를 자동으로 알 수 있는 방법
		배열이름.length 
 */
public class Array02Main {

	public static void main(String[] args) {
		System.out.println("배열의 선언과 초기화");
		
		int[] kor =new int[3]; 
		
		kor[0]=100;
		kor[1]=90;
		kor[2]=80;
		
		for (int i = 0; i < kor.length; i++) {
			System.out.println();
		}
		
		//length  : 데이터갯수
		//size : 데이터용량
		
		
		//선언과동시에 초기화
		int[] eng=new int[] {30,40,20};
		for (int i = 0; i < eng.length; i++) {
			System.out.println("영어 "+i+" : "+eng[i]);
		}
		
		int[] math= {99,88,77,66};
		for (int i = 0; i < math.length; i++) {
			System.out.println("수학 "+i+" : "+math[i]);
		}
		
		//수학점수 총점 평균 계산
		int total=0;
		for (int i = 0; i < math.length; i++) {
			total=total+math[i];
		}
		double avg=(double)total/math.length;
		System.out.println("수학평균 : "+avg);
		
		
		
	} // end main()

} // end class Array02Main











