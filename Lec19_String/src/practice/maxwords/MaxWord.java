package practice.maxwords;

import java.util.Scanner;
import java.util.StringTokenizer;

/* MaxWrod
	여러문장으로 구성된 문자열을 입력받은뒤 
	문자열에서 가장 단어의 개수가 많은 문장을 찾아서, 
	그 문장과 문장의 단어의 개수를 출력
	'문장'의 구분은  .(마침표) !(느낌표) ?(물음표) 로 한다.
	'단어'구분은 '공백' 으로 한다
	
	입력예]
	We test coders. Give us a try. Can you make it out? It's awesome.
	
	출력예]
	5개
	Can you make it out
 */
public class MaxWord {

	// TODO : 필요한 메소드 있으면 추가 작성

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String userInput =""; // 사용자 입력값.

		System.out.println("입력하세요");
		userInput = sc.nextLine();
		maxWords(userInput);

		sc.close();
	} // end main

	public static void maxWords(String inpuString) {
		String maxMunjang = "";
		int maxWordCount=0;
		int wordCount=0;
		StringTokenizer st = new StringTokenizer(inpuString,".,?,!");  //문장으로 나누기
		String munJang[]=new String[st.countTokens()];
		
		//문장으로 나눈 값 배열에 넣기
		while (st.hasMoreElements()) {
			for (int j = 0; j < munJang.length; j++) {
				munJang[j]=st.nextToken();
			}
		}
		//가장 긴 문장을 찾기
		for (int i = 0; i < munJang.length; i++) {
			maxWordCount=munJang[0].length();
			if(maxWordCount<munJang[i].length()) {
				maxMunjang=munJang[i].toString();
			}
		}
		StringTokenizer st1 = new StringTokenizer(maxMunjang," "); //가장 긴 문장을 공백으로 나누기
		wordCount=st1.countTokens();  //나눈 문장에서  그 갯수 구하기
		
		System.out.println(wordCount+"개");
		System.out.println(maxMunjang);
		
	} //end maxWords(String)
} // end class
