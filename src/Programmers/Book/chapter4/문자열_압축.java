package Programmers.Book.chapter4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://school.programmers.co.kr/learn/courses/30/lessons/60057
public class 문자열_압축 {

	public static void main(String[] args) {
		문자열_압축 cons = new 문자열_압축();

		System.out.println(cons.solution("ababcdcdababcdcd"));
	}

	private List<String> split(String source, int length) { // 주어진 문자열에 주어진 숫자만큼 짜른다.

		List<String> tokens = new ArrayList<>();

		for (int startIndex = 0; startIndex < source.length(); startIndex += length) {
			int endIndex = startIndex + length;
			if (endIndex > source.length()) endIndex = source.length();
			tokens.add(source.substring(startIndex, endIndex));
		}

		System.out.println("length : " + length + " tokens : " + tokens.toString());

		return tokens;
	}

	private int compress(String source, int length) {

		StringBuilder builder = new StringBuilder();

		String last = "";
		int count = 0;

		for (String token : split(source, length)) {
			if (token.equals(last)) {
				count++;
			} else {
				if (count > 1) builder.append(count);

				builder.append(last);
				last = token;
				count = 1;
			}
		}
//		System.out.println("builder : " + builder.toString());

		if (count > 1) builder.append(count);
		builder.append(last);

		return builder.length();
	}

	public int solution(String s) {

		int min = Integer.MAX_VALUE;

		for (int length = 1; length <= s.length(); length++) {

			int compressed = compress(s, length);

			if (compressed < min) {
				min = compressed;
			}

		}
		return min;
	}

	private int compress1(String source, int length) {
		//길이별로 압축한다.

		List<String> list = new ArrayList<>();

		StringBuilder sb = new StringBuilder();

		// 있으면 그 앞에숫자를 곱하고.




		return 0;
	}

	private List<String> split1(String source, int length) {


		return Arrays.asList("s");
	}
}
