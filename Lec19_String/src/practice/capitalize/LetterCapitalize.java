package practice.capitalize;

import java.util.Arrays;
import java.util.Scanner;

/* LetterCapitalize
 * 	문장을 입력하고,  단어의 앞 문자를 대문자로 만들어 출력하기를 반복하다가
 *  quit 을 입력 받으면 종료하기
 * 
 * 	[입력예]
 * 		hello my world
 *  [출력예]
 * 		Hello My World  
 */

public class LetterCapitalize {

	// TODO : 필요한 메소드 있으면 추가 작성

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String userInput = "";

		String[] word;
		while (true) {
			userInput = sc.next();
			if (userInput.trim().equalsIgnoreCase("quit")) {
				break;
			}
			userInput=userInput.toLowerCase();
			word = userInput.split("\\s+");
			
			for (String check : word) {
				String firstLetter =check.substring(0,1).toUpperCase();
				String rest=check.substring(1);
				System.out.print(firstLetter+rest+" ");
			}

		}

		// TODO

		sc.close();
	} // end main()
} // end class
