package java.Programmers.Book.chapter11;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

//https://school.programmers.co.kr/learn/courses/30/lessons/67258
public class 보석쇼핑 {

	/* 1)


	 */

	public static void main(String[] args) {

		보석쇼핑 cons = new 보석쇼핑();

		String[] gem = {"XYZ", "XYZ", "XYZ"};

		Arrays.stream(cons.solution(gem)).forEach(System.out::println);

	}

	public int[] solution(String[] gem) {
		int start = 0;
		int end = 0;
		int s = 0;
		int e = 0;

		int count = new HashSet<>(Arrays.asList(gem)).size();

		Map<String, Integer> map = new HashMap<>();

		map.put(gem[s], 1);


		while (start < end) {

			if(map.keySet().size()==count) {
			}

			map.put(gem[e], map.get(gem[e]) - 1);

			if (map.keySet()
					.size() < count) {
				e++;
			}

		}

		return new int[]{start + 1, end + 1};
	}



	}

