package Programmers.Book.charpter8;

import java.util.*;

public class 순위_검색_test {

	Map<String, List<Integer>> map ;



	public int[] solution(String[] info, String[] query) {

		int[] answer = new int[query.length];

		for (int i = 0; i < info.length; i++) {
			makeCase(0,"",info);


		}

		for (String key : map.keySet()) {
			Collections.sort(map.get(key));
		}

		for (int i = 0; i < query.length; i++) {
			query[i] = query[i].replaceAll(" and ", "");
			String[] strings = query[i].split("");


		}

		return answer;

	}

	public void makeCase(int seq , String key, String[] arr ) {

		if (seq == 4) {
			if (map.containsKey(key)) {
				List<Integer> list = new ArrayList<>();
				map.put(key, list);
			}
			map.get(key).add(Integer.parseInt(arr[4]));
			return ;
		}

		makeCase(seq+1, key+"-",arr);
		makeCase(seq+1, key+arr[seq],arr);

	}


}
