package Programmers.Book.chapter11;

import java.util.*;
import java.util.stream.IntStream;

//https://school.programmers.co.kr/learn/courses/30/lessons/67258
public class 보석쇼핑 {

	public static void main(String[] args) {

		보석쇼핑 cons = new 보석쇼핑();

		String[] gem = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};

		Arrays.stream(cons.solution(gem)).forEach(System.out::println);

	}

	public int[] solution(String[] gem) {
		int start = 0;
		int end = 3;

		Set<String> checkGem = new HashSet<>();
		List<int[]> answer = new ArrayList<>();


		while (true) {
			checkGem.clear();
			System.out.println("start : " + start + " end : " + end);

			for (int i = start; i < end; i++) {

				checkGem.add(gem[i]);
			}
			System.out.println(checkGem.toString());

			// 계속 증가해서 끝까지가면 종료
			if (start == end) break;

			// 마지막 포인터가 끝까지가면 계속 증가시켜야함
			if (end == gem.length ) {
				start++;
				continue;
			}

			if (checkGem.size() == 4) { // 4일 때 삽입하고

				answer.add(new int[]{start, end});
				start++;
			} else if(checkGem.size() < 4 || end != gem.length -1){
				end++;
			}

			if (start == end) break;
		}

		for (int[] i : answer) {
			System.out.println(i[0] + "  " + i[1]);

		}


		return answer.stream().min(Comparator.comparing(arr -> Math.abs(arr[1] - arr[0]))).map(Arrays::stream).orElse(IntStream.empty()).toArray();
	}
}
