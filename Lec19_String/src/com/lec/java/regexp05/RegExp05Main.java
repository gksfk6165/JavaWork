package com.lec.java.regexp05;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 대표적인 정규 표현식 
 *  구글링 하면 대표적인 정규표현식들이 많이 구할수 있습니다.
 *  각 정규표현식들을 작성해보고
 *	매칭되는 문자열과 그렇지 않은 것들을 출력해봅시다.   
 */
public class RegExp05Main {

	public static void main(String[] args) {
		System.out.println("많이 쓰는 정규표현식");

		String regex, title;
		String [] arrInput;
		
		//─────────────────────────────────────────
		title = "URL";
		regex = "^((http|https)://)?(www.)?([a-zA-Z0-9]+)\\.[a-z]+([a-zA-z0-9.?#]+)?"; 
		arrInput = new String[] {
			"http://www.naver.com",
			"http://google.com",
			"ht://goolg.com",
		};
		System.out.println(title);
		regExpTest(regex, arrInput);

		//─────────────────────────────────────────
		title = "email";
		regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$"; 
		arrInput = new String[] {
			"tjrals1991@gmail.com",
			"naver.com"
		};
		System.out.println(title);
		regExpTest(regex, arrInput);

		//─────────────────────────────────────────
		title = "주민등록번호";
		regex = "^\\d{2}(0[1-9]|1[0-2])(0[1-9]|[12][0-9]|[3][01])\\-[1-4][0-9]{6}$"; // TODO
		arrInput = new String[] {
			"910817-1234567",
			"900-1919197788"
		};
		System.out.println(title);
		regExpTest(regex, arrInput);
		
		//─────────────────────────────────────────
		title = "날짜 YYYY-MM-DD";
		regex = "[0-9]{4}-[0-9]{2}-[0-9]{2}"; // TODO
		arrInput = new String[] {
			"2010-08-17",
			"2012-01-21",
			"12-00-22"
		};
		System.out.println(title);
		regExpTest(regex, arrInput);
		
		//─────────────────────────────────────────

		title = "자연수";
		regex = "^[1-9][0-9]*$"; // ^(0[1-9][0-9]*)$ 0을 포함하는 자연수
		arrInput = new String[] {
			"-1",
			"100",
			"0",
		};
		System.out.println(title);
		regExpTest(regex, arrInput);

		//─────────────────────────────────────────
		title = "정수";
		regex = "^(0|-?[1-9][0-9]*)$"; // TODO
		arrInput = new String[] {
			"-1",
			"100",
			"0",
		};
		System.out.println(title);
		regExpTest(regex, arrInput);

		//─────────────────────────────────────────
		title = "소수";
		regex = "^[0-9]+(.[0-9]+)?$"; // 
		arrInput = new String[] {
			"0.1",
			"0.01",
			"1.5",
		};
		System.out.println(title);
		regExpTest(regex, arrInput);

		//─────────────────────────────────────────
		title = "소숫점 둘째자리까지";
		regex = "^[0-9]+(.[0-9])?$"; // 
		arrInput = new String[] {
			"0.1",
			"0.01",
			"1.5",
		};
		System.out.println(title);
		regExpTest(regex, arrInput);

		//─────────────────────────────────────────
		title = "통화표시 (￦)";
		regex = "^[0-9][\\]";
		arrInput = new String[] {
			"1000\\",
			"2000$",
			"3000$",
		};
		System.out.println(title);
		regExpTest(regex, arrInput);

		System.out.println("프로그램 종료");

	} // end main()

	// 도우미 함수
	public static void regExpTest(String regex, String[] arrInput) {
		for (String input : arrInput)
			regExpTest(regex, input);
		System.out.println("======================================");
	}

	public static void regExpTest(String regex, String input) {
		//System.out.println("[정규표현식 매칭 테스트]-----------------");
		//System.out.println("정규표현식: " + regex);
		System.out.println("입력문자열: " + input);

		if(Pattern.matches(regex, input)) {
			System.out.println("●매칭●");
		} else {
			System.out.println("Ⅹ매칭 없슴Ⅹ");
		}
		
		
	} // end regExpTest()

} // end class
