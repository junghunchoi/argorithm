package Programmers.Book.chapter5;

import java.util.ArrayList;
import java.util.List;

public class 모음사전 {

	private static final char[] CHARS = "AEIOU".toCharArray();

	// 문자를 이어붙이면서 문자의 길이를 체크한다.
	// 1억회에 한참 못미치는 2만회정도 배열에 삽입하는 것은 전혀 문제가 되지 않는다.
	// 아래와 같이 재귀를 통해 배열을 만든 후 문제를 풀어본다.
	private List<String> generate(String word) {
		List<String> words = new ArrayList<>();

		words.add(word);
		System.out.println("word : " + word);

		// 주어진 조건이 5자리이므로 5자리가 되었을 때 리턴할 수 있도록.
		if (word.length() == 5) return words;

		for (char c : CHARS) {

			words.addAll(generate(word + c));

		}

		return words;
	}

	public int solution(String str) {
		return generate("").indexOf(str);
	}
}
