package com.lec.java.string04;

import java.util.Arrays;
import java.util.StringTokenizer;

/* StringTokenizer 클래스

	token ? : '규칙'에 의해 구분된 더 이상 나눌수 없는 문자요소(문자열)
				(문법적으로 더 이상 나눌 수 없는 기본적인 언어요소)
*/

public class String04Main {

	public static void main(String[] args) {
		System.out.println("StringTokenizer 클래스");
		
		// token <- '규칙'에 의해 구분된 문자덩어리(문자열)?
		String str1 = "13:46:12";
		StringTokenizer tokenizer=new StringTokenizer(str1,":");
		System.out.println(tokenizer.countTokens());
		
		while(tokenizer.hasMoreTokens()) {
			System.out.println(tokenizer.nextToken());
		}
		//tokenizer.nextToken(); //java.util.NoSuchElementException
		
		System.out.println();
		String str2 = "abc:def:ghi:jkl:mno";   // : 로 토큰분리

		StringTokenizer str2Token=new StringTokenizer(str2,":");
		while (str2Token.hasMoreTokens()) {
			System.out.println(str2Token.nextElement());
			
		}
		
		
		System.out.println();
		String str3 = "2015/04/08";     // / 로 토큰분리

		StringTokenizer str3Token=new StringTokenizer(str3,"/");
		while (str3Token.hasMoreTokens()) {
			System.out.println(str3Token.nextElement());
			
		}
		
		
		System.out.println();
		String str4 = "2015년-4월-8일";   // - 으로 토큰분리

		StringTokenizer str4Token=new StringTokenizer(str4,"-");
		while (str4Token.hasMoreTokens()) {
			System.out.println(str4Token.nextElement());
			
		}
		
		
		System.out.println();
		String str5 = "2015-04-08 14:10:55";
		StringTokenizer str5Token=new StringTokenizer(str5,"-,:, ");
		while (str5Token.hasMoreTokens()) {
			System.out.println(str5Token.nextElement());
			
		}
		
		// TODO
		
		
		System.out.println();
		// StringTokenizer 생성자의 세번째 매개변수를 true 로 주면
		// delimiter 도 token 으로 추출된다
		String str6 = "num += 1";
		
		StringTokenizer str6Token=new StringTokenizer(str6,"+=",true);
		while (str6Token.hasMoreTokens()) {
			System.out.println(str6Token.nextElement());
			
		}
		

		// TODO
		
		
		// 실습]
		// 다음과 같은 수식이 있을때  토큰들을 분리해네세요
		// 연산자 + - / *   괄호 ( )
		// 10  +  (name * 2) / num8- (+3)
		// 힌트]
		// 일단 공백으로 분리 split()
		// 그리고 나서 각각을 StringTokenizer 함
		
		System.out.println();
		System.out.println("수식 분석기");
		String exprToken = "10  +  (name * 2) / num8- (+3)";
		String [] exprTokenSplit=exprToken.split("\\s");
		
		String str7Token=Arrays.toString(exprTokenSplit);
		
		StringTokenizer check=new StringTokenizer(str7Token,"+,/,-",true);
		while (check.hasMoreTokens()) {
			System.out.print(check.nextElement());
			
		}
		
		
		
		

		System.out.println("\n프로그램 종료");
	} // end main()

} // end class











