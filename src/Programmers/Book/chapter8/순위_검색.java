package Programmers.Book.chapter8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

//https://school.programmers.co.kr/learn/courses/30/lessons/72412
public class 순위_검색 {

	/* 2023.07.24 실패

	 */

	public static void main(String[] args) {

		순위_검색 cons1 = new 순위_검색();

		String[] info = {"java backend junior pizza 150", "python frontend senior chicken 210", "python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80", "python backend senior chicken 50"};
		String[] query = {"java and backend and junior and pizza 100", "python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250", "- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150"};

		cons1.solution(info, query); //1,1,1,1,2,4 나와야함

	}

	private int binarySearch(String key, int score, HashMap<String, List<Integer>> map) {
		// 문자열이나 map에서 이진탐색은 어떤식으로 진행해야하는가?
		// -> 일단 문자열 아니다. 이진탐색은 인덱스 값을 찾는것도 가능하고 결과값을 찾는 것도 가능하다.
		List<Integer> list = map.get(key);
		int start = 0;
		int end = list.size() - 1;

		while (start <= end) {
			int mid = (start + end) / 2;
			if (list.get(mid) < score) start = mid + 1;
			else end = mid - 1;
		}
		return list.size() - start; // key에 해당하는 총 점수 - 점수보다 작은 점수 삭제
	}

	private void makeCase(String[] arr, String str, int cnt, HashMap<String, List<Integer>> map) {
		if (cnt == 4) {
			if (!map.containsKey(str)) {
				// 왜 리스트에 담아서 넣느냐? 키 하나에 여러값이 들어갈 수 있으면 list에 값을 담아 관리한다.
				List<Integer> list = new ArrayList<>();
				map.put(str, list);
			}
			map.get(str).add(Integer.parseInt(arr[4]));
		}

		makeCase(arr, str + "-", ++cnt, map);
		makeCase(arr, str + arr[cnt], ++cnt, map);
	}

	public int[] solution(String[] info, String[] query) {
		int[] answer = new int[query.length];
		HashMap<String, List<Integer>> map = new HashMap<>();

		for (String infodetail : info) {
			makeCase(infodetail.split(" "), "", 0, map);
		}

		// !! 이진탐색은 정렬되어 있어야한다.
		for (String key : map.keySet()) {
			Collections.sort(map.get(key));
		}

		/*
		파라미터 셋팅하는 방법.
		-> 메소드와 파라미터를 확실히 정했다면 파라미터는 그리디처럼 만들어서 셋팅한다.
		 */
		for (int i = 0; i < answer.length; i++) {
			String[] strings = query[i].replace(" and ", "").split(" ");

			answer[i] = map.containsKey(strings[0]) ? binarySearch(strings[0], Integer.parseInt(strings[1]), map) : 0;
		}

		return answer;
	}

}
