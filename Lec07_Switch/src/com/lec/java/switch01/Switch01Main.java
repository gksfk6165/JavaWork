package com.lec.java.switch01;

/* switch - case 조건문
 * 
 * 	switch (조건값){
 * 	case 값1:
 * 		...
 * 	case 값2:
 * 		...
 *	default:
 *		...
 *	}
 *
 * 	해당 조건의 case문을 찾아서 거기서부터 break를 만날 때까지 실행을 함.
 *  break를 만나게 되면 switch 문장을 종료.
 *  해당하는 case가 없으면 default 문장을 실행함.
 *  
 *  	※ 모든 switch 조건문은 if - else if - else로 바꿀 수 있다. (할수 있어야 한다)
 */
public class Switch01Main {

	public static void main(String[] args) {
		System.out.println("switch 문");

		int num = 4;

		switch (num) {
		case 1:
			System.out.println("one");
			break;
		case 2:
			System.out.println("two");
			break;
		case 3:
			System.out.println("three");
			break;

		default:
			System.out.println("?");
			break;
		}
		// TODO

		System.out.println();
		// 모든 switch 조건문 if - else if - else로 바꿀 수 있다.
		// TODO
		if (num == 1) {
			System.out.println("1");
		} else if (num == 2) {
			System.out.println("2");
		} else if (num == 3) {
			System.out.println("3");
		} else if (num == 4) {
			System.out.println("4");
		} else {
			System.out.println("?");
		}
		
		

		System.out.println("\n프로그램 종료");
	} // end main()

} // end class
