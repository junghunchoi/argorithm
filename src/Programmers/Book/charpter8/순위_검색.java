package Programmers.Book.charpter8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

//https://school.programmers.co.kr/learn/courses/30/lessons/72412
public class 순위_검색 {

	private static int binarySearch(String key, int score, HashMap<String, List<Integer>> map) {

		List<Integer> list = map.get(key); //
		System.out.println("binary => "+ list.toString());

		int start = 0;
		int end = list.size() - 1;

		while (start <= end) {
			int mid = (start + end) / 2;
			if (list.get(mid) < score) start = mid + 1;
			else end = mid - 1;
		}

		// key에 해당하는 점수의 총 개수 - 점수보다 크거나 같은 처음 인덱스
		return list.size() - start;
	}

	public int[] solution(String[] info, String[] query) {

		int[] answer = new int[query.length];

		HashMap<String, List<Integer>> map = new HashMap<>();

		for (int i = 0; i < info.length; i++) {

			String[] arr = info[i].split(" ");

			makeCase(arr, "", 0, map);
		}


		for (String key : map.keySet()) {
			Collections.sort(map.get(key));
		}

		for (int i = 0; i < query.length; i++) {
			query[i] = query[i].replaceAll(" and ", "");
			String[] strings = query[i].split(" ");
			System.out.println("key : "+ strings[0]);
			answer[i] = map.containsKey(strings[0]) ? binarySearch(strings[0], Integer.parseInt(strings[1]), map) : 0; // 키가 포함되어 있을 때 아예 해당되지 않는 경우는 0을 반환
		}

		return answer;
	}

	private void makeCase(String[] arr, String str, int cnt, HashMap<String, List<Integer>> map) {

		if (cnt == 4) { // 4칸 만들어졌으면 map에 삽입을 해야지
			if (!map.containsKey(str)) { //
				List<Integer> list = new ArrayList<>();
				map.put(str, list);
			}
			map.get(str).add(Integer.parseInt(arr[4]));
			return;
		}

		makeCase(arr, str + "-", cnt + 1, map);
		makeCase(arr, str + arr[cnt], cnt + 1, map);
	}
}
