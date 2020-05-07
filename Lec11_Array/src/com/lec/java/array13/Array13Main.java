package com.lec.java.array13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* java.util.Arrays 클래스
     배열을 다루는 유용한 메소드들 제공
		Arrays.toString() : 문자열 형태로 리턴
		Arrays.copyOf(원본배열, 복사할 length)
		Arrays.copyOfRange(원본배열, from, to))
		Arrays.fill()  : 배열에 특정 값으로 채우기
		Arrys.sort(원본배열) :  오름차순 변경
		Arrays.asList() : array -> List 로
 */
public class Array13Main {

	public static void main(String[] args) {
		System.out.println("java.util.Arrays 클래스");
		int[] arr= {10,20,30,40,50};
		
		System.out.println(Arrays.toString(arr));
		
		// Arrays.copyOf(원본배열, 복사할 length)
		// 배열을 복사하여 새로운 배열생성하여 리턴
		int [] arr2=Arrays.copyOf(arr, 3);
		System.out.println(Arrays.toString(arr2));
		int [] arr3=Arrays.copyOf(arr, 10); //업는값은 기본값으로 채움.
		System.out.println(Arrays.toString(arr3));
		
		int [] arr7= {8,9,3,4,1,3,2};
		Arrays.sort(arr7);
		System.out.println(Arrays.toString(arr7));

		
		int [] arr8= {1,1,1,1};
		int [] arr9= {1,1,1,1};
		System.out.println(arr8==arr9); //주소를 비교하기때문에 하면안되는비교
		System.out.println(Arrays.equals(arr8, arr9));
		
		//
		
		
	} // end main

} // end class
