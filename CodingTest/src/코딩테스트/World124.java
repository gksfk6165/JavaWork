package 코딩테스트;

public class World124 {
	public static void main(String[] args) {
		String answer = "";
		int n = 10;
		int namoji;
		while (n > 0) {
			namoji = n % 3;
			n = n / 3;
			// System.out.println(n+" ##");
			if (namoji == 0) {
				n = n - 1;
				namoji = 4;
				// System.out.println(n+" @@");
			}
			// System.out.println(n+" / "+namoji);
			answer = namoji + answer;
			// System.out.println(anwser+" <--- anwser");
		}
		System.out.println(answer);
	}
}
