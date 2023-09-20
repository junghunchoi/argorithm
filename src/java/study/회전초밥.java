package java.study;

import java.util.HashMap;
import java.util.Map;

//https://www.acmicpc.net/problem/2531
public class 회전초밥 {

	public static void main(String[] args) {

		System.out.println(addsolution(8, 30, 4, 30, new int[]{7, 9, 7, 30, 2, 7, 9, 25}));

	}


	public static int solution(int n, int d, int k, int c, int[] sushi) {//접시의 수 , 초밥의 가짓수, 연속해서 먹는 접시수, 쿠폰 번호

		int[] sushitable = new int[n+k-1];

		for (int i = 0; i < n; i++) {
			sushitable[i] = sushi[i];
		}

		for (int i = n; i < n+k-1; i++) {
			sushitable[i] = sushitable[i - n];
		}

		int answer = 0;

		HashMap<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < k; i++) {
			map.compute(sushitable[i], (key, v) -> v == null ? 1 : v + 1);
		}

		if (map.containsKey(c)) {
			answer = map.size() + 1;
		} else answer = map.size();


		for (int i = 0; i < n-1; i++) {
			System.out.println(map.toString());

			if (map.get(sushitable[i]) == 1) map.remove(sushitable[i]);
			else map.put(sushitable[i], map.get(sushitable[i]) - 1);

			map.compute(sushitable[i+k], (key, v) -> v==null ? 1 : v + 1);

			if (!map.containsKey(c)) answer = Math.max(answer, map.size() + 1);
			else answer = Math.max(answer, map.size());
		}

		return answer;
	}

	public static int addsolution(int n, int d, int k, int c, int[] sushi) {//접시의 수 , 초밥의 가짓수, 연속해서 먹는 접시수, 쿠폰 번호

		int answer = 0;
		Map<Integer, Integer> map = new HashMap<>();

		int[] sushitable = new int[n + k];

		for (int i = 0; i < n; i++) {
			sushitable[i] = sushi[i];
		}

		for (int i = n; i < n+k-1 ; i++) {
			sushitable[i] = sushi[i - n];
		}

		//7, 9, 7, 30, 2, 7, 9, 25
		for (int i = 0; i < k; i++) {
			map.put(sushitable[i], map.getOrDefault(sushitable[i],0) + 1);

			if (!map.containsKey(c)) answer = map.size() + 1;
			else answer = map.size();

		}

		for (int i = 0; i < n-1; i++) {
			if(map.get(sushitable[i])==1) map.remove(sushitable[i]);
			else map.compute(sushitable[i], (key, value) -> map.get(key) - 1);

			map.put(sushitable[i + k], map.getOrDefault(sushitable[i + k], 0) + 1);

			if (!map.containsKey(c)) answer = Math.max(answer, map.size() + 1);
			else answer = Math.max(answer, map.size() );
		}


		return answer;
	}
}
