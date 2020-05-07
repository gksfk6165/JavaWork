package 코딩테스트;

public class SkillTree {
	public static void main(String[] args) {
		String skill = "CBD";
		String[] skill_trees = {"CDE"};
		
	

		int answer = 0;
		// 스킬트리 갯수만큼 반복하면서 스킬트리 문자와 스킬 문자 비교하기
		// 첫번쨰 스킬 첫 문자랑 스킬 첫문자 비교하기
		// 같은 문자가 없으면 카운트 증가
		//
		for (int i = 0; i < skill_trees.length; i++) {
			int next=0;
			boolean check=true;
			// 첫번쨰 스킬 첫 문자랑 스킬 첫문자 비교하기
			for (int j = 0; j < skill_trees[i].length(); j++) {

				for (int j2 = next; j2 < skill.length(); j2++) { // 첫 문자 비교완료하면 그걸로 안하고 다음 문자열로 비교

					System.out.print("스킬 문자  -- " + skill.charAt(j2) + "\n");
					System.out.print("스킬트리 문자열 한개씩  -- " + skill_trees[i].charAt(j) + " \n");
					
					if(skill.charAt(j2)==skill_trees[i].charAt(j)) {   //스킬 첫번쨰 문자랑 스킬트리 각 문자열 비교  같은문자가잇으면
						//일단 문자열은 같음
						System.out.println("일단 문자열은 같음");
						
						//그 위치를 확인
						if(j2!=next) {
							System.out.println(j2 +   "  -- 인덱스가 다를떄  --   "+ next);
							check=false;
						}
						else {
							next++;
							System.out.println("인덱스가 같으니까 증가  ----- "+next);
						}
					}
					System.out.println("같은게 없으니까 다음 문자열 비교하자");
					System.out.println();
					
				}//3번쨰포

			}//2번쨰포
			System.out.println("-----------------------"+i+"번째 단어  도는중------------------------------");
			if(check) {
				answer++;
				System.out.println("-------------------------------------------------------------증가 "+answer);
			}
			System.out.println(answer+" // "+skill_trees[i]);

		}

	}
}
