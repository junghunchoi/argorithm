package study;

import java.util.*;

//https://school.programmers.co.kr/learn/courses/30/lessons/67258
public class 보석쇼핑 {

	/* 1) 2023.07.21


	 */
	public static void main(String[] args) {

		보석쇼핑 cons = new 보석쇼핑();

		String[] gem = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};

		System.out.println((cons.solution(gem))[0] + "   " + cons.solution(gem)[1]);

	}

	// 가장 짧은 구간을 리턴
	public int[] solution(String[] gem) {
		int start = 0;
		int end = gem.length;
		int s = 0;
		int e = 0;

		int count = new HashSet<>(Arrays.asList(gem)).size();

		Set<String> checkGem = new HashSet<>();
		Map<String, Integer> map = new HashMap<>();

		for (String str : gem) {
			checkGem.add(str);
		}

		for (int i = s; i < e; i++) {
			map.put(gem[i], map.getOrDefault(gem[i], 0) + 1);
		}

		while (true) {

			if (e - s < end - start) {
				start = s;
				end = e;
			}


			if (map.keySet().size() == checkGem.size()) {

				if (map.get(gem[s]) >= 2) map.put(gem[s], map.get(gem[s]) - 1);
				else map.remove(gem[s]);

				s++;
			} else {

				map.put(gem[e], map.getOrDefault(gem[e], 0) + 1);
				e++;
			}
			System.out.println("s : " + s + " e : " + e + " map : " +map.toString());

			// end가 끝까지 갔는데 종류가 몇개 없다? 종료
			if(e== gem.length-1 &&  map.keySet().size() < checkGem.size())			break;
		}

		return new int[]{start + 1, end + 1};
	}
}
