package Programmers.Book.chapter11;

import java.util.*;
import java.util.stream.IntStream;

//https://school.programmers.co.kr/learn/courses/30/lessons/67258
public class 보석쇼핑 {

	/* 1) 2023.07.21


	 */

	public static void main(String[] args) {

		보석쇼핑 cons = new 보석쇼핑();

		String[] gem = {"XYZ", "XYZ", "XYZ"};

		Arrays.stream(cons.solution(gem)).forEach(System.out::println);

	}

	public int[] solution(String[] gem) {
		int start = 0;
		int end = 0;

		int count = new HashSet<>(Arrays.asList(gem)).size();

		Set<String> checkGem = new HashSet<>();
		List<int[]> answer = new ArrayList<>();


		while (true) {
			checkGem.clear();
			System.out.println("start : " + start + " end : " + end);

			for (int i = start; i <= end; i++) {

				checkGem.add(gem[i]);
			}
			System.out.println(checkGem.toString());

			if (checkGem.size() == count) {

				answer.add(new int[]{start+1, end+1});

				start++;
			}

			// 마지막 포인터가 끝까지가면 계속 증가시켜야함
			if (end == gem.length-1 ) {
				start++;
				continue;
			}


			if(checkGem.size() < count ){
				end++;
			}

			if (start == end && end==gem.length-1) break;
		}
		answer.toString();
		return answer.stream().min(Comparator.comparing(arr -> Math.abs(arr[1] - arr[0]))).map(Arrays::stream).orElse(IntStream.empty()).toArray();
	}
}
