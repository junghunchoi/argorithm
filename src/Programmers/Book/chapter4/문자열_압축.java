package Programmers.Book.chapter4;

import java.util.ArrayList;
import java.util.List;

public class 문자열_압축 {

    static String str = "ababcdcdababcdcd";

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
				System.out.println("token : " + token.toString());

			} else {
				if (count > 1) builder.append(count);

				builder.append(last);
				last = token;
				count = 1;
			}
		}
		System.out.println("builder : " + builder.toString());

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
}
