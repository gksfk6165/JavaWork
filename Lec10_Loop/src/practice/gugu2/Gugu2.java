package practice.gugu2;

public class Gugu2 {
	public static void main(String[] args) {
		
		for (int i = 1; i < 9; i+=3) {   //총 3단 실행햇기떄문에 다음 구구단은 +3증가한 단
			
			for (int j = 1; j < 10; j++) {    //구구단 곱셈값 증가
				
				for(int k= 1; k < 4; k++) { // 2x1 3x1 4x1   단 1씩 증가를 위해서
					
					//단이 10단이 되면 그만!
					if(i+k==10) {
						break;
					}
					System.out.print((i+k)+" x "+j+" = "+(i+k)*j +"  /  "); //각  단 첫행부터 출력을 위해   단 x 1 반복
					
				}
				System.out.println();
			}
			System.out.println();
		}
	}
}
