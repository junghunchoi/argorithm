package javaalgorithm.Programmers.Book.chapter8;

import java.util.*;

//https://school.programmers.co.kr/learn/courses/30/lessons/72412
public class 순위_검색 {

	/* 2023.07.24 실패

	 */

	public static void main(String[] args) {

		순위_검색 cons1 = new 순위_검색();

		String[] info = {"java backend junior pizza 150", "python frontend senior chicken 210", "python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80", "python backend senior chicken 50"};
		String[] query = {"java and backend and junior and pizza 100", "python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250", "- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150"};

		Arrays.stream(cons1.solution(info, query)).forEach(System.out::println); //1,1,1,1,2,4 나와야함

	}


	private static int binarySearch(String key, int score, HashMap<String, List<Integer>> map) {

		List<Integer> list = map.get(key); //
		System.out.println("binary => " + list.toString());

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

		System.out.println(map.toString());
		System.out.println("containkey" + map.get("----"));

		// 질의별로 돌면서 얼마나 들어있는지 체크
		for (int i = 0; i < query.length; i++) {
			query[i] = query[i].replaceAll(" and ", "");
			String[] strings = query[i].split(" ");
			System.out.println("key : " + strings[0]);
			answer[i] = map.containsKey(strings[0]) ? binarySearch(strings[0], Integer.parseInt(strings[1]), map) : 0; // 키가 포함되어 있을 때 아예 해당되지 않는 경우는 0을 반환
		}

		return answer;
	}

}
