package practice.wordcount;

import java.awt.color.CMMException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

/* 1] 문서(문자열) 안의 단어의 빈도수를 계수해서 출력하기
 * 	- 대소문자 구분하지 않기 :   The 와 the 는 같은 단어
 *  - 2글자 이상만 계수하기
 *  - 구두점/기호 ",.\"\'`!?;:-()" 잘라내기
 *  - 공백 짤라내기
 * ex)
 * 	an : 234
 * 	the : 314
 * ...
 * 
 * hint]
 * 	split("\\s+")  --> String[]   
 * 	--> StringTokenizer  (혹은 정규표현식)
 *  	  --> HashMap<String, Integer>   <단어, 빈도수>  사용
 * ───────────────────────────────────────────────────────────    
 * 2] 빈도수 내림차순으로 정렬하여 출력하기
 * 	ex)
 *	1 the:113개
 *	2 she:95개
 *	3 to:85개
 *	...   
 *
 * hint]
 * 	Comparable<> 이나 Comparator<> 적용
 */

// TODO : 필요한 객체들 작성
// hint> 빈도수 담을 객체, Comparator<> ..

public class AliceInWonderland {

	public static void main(String[] args) {
		HashMap<String, Integer> hmap = new HashMap<String, Integer>();
		List<String> list = new ArrayList<String>();

		String split;  // 공백제거 ,대소문자 구분 안하고 split한 문자열값 담을변수
		int overlap = 0; //중복 체크 횟수용 변수

		String[] words = C.ALICE30.trim().toLowerCase().split("\\s+");
		split = Arrays.toString(words); 
		StringTokenizer st = new StringTokenizer(split, " ,.\"\'`!?;:-()*[]_"); 
		
		while (st.hasMoreTokens()) {
			list.add(st.nextToken());    
		}
		for (int i = 0; i < list.size(); i++) {

			for (int j = 0; j < list.size(); j++) {
				//2자리가 안되면 그만
				if (list.get(i).length() < 2) {
					break;
				}
				//2자리부터는 값비교하며 같을시 카운트증가
				if (list.get(i).equals(list.get(j))) {
					overlap++;
				}
				hmap.put(list.get(i), overlap);  //hashmap에  담아준다.
			}
			overlap = 0; //담고나서는 카운트초기화
		}
//		for (String key : hmap.keySet()) {
//			System.out.println(key + " : " + hmap.get(key));
//		}
		sortValue(hmap); // value값 정렬
		System.out.println("\n============================\n");
		sortkey(hmap); //key값 정렬

		System.out.println("\n프로그램 종료");
	} // end main()

	//키값정렬
	public static void sortkey(HashMap<String, Integer> map) {

		TreeMap<String, Integer> tm = new TreeMap<String, Integer>(map);
		
		Iterator<String> iteratorKey = tm.keySet().iterator(); // 키값 오름차순 정렬
		//Iterator<String> iteratorKey = tm.descendingKeySet().iterator(); // 키값 내림차순
		
		System.out.println("\tKEY값으로 정렬 출력\n");
		while (iteratorKey.hasNext()) {
			String key = iteratorKey.next();
			//System.out.println(key + "\t\t" + tm.get(key));
			System.out.printf("%15s - %d개",key,tm.get(key));
			System.out.println();
		}
	}//end sortkey(hashmap)
	
	//value값정렬
	public static void sortValue(HashMap<String, Integer> map) {
		List<String> list = new ArrayList<String>();
		list.addAll(map.keySet());
		Collections.sort(list, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return map.get(o1).compareTo(map.get(o2)); // 오름차순
				//return map.get(o2.compareTo(map.get(o1)); //내림차순
				
			}
		});
		System.out.println("\tVALUE값으로 정렬 출력\n");
		for (String key : list) {
			//System.out.println(key + "\t\t" + map.get(key) + "개");
			System.out.printf("%15s - %d개",key,map.get(key));
			System.out.println();
		}
	}//end sortValue(hashmap)
	
} // end class
