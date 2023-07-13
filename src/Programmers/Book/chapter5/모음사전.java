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

		if (word.length() == 5) return words;

		for (char c : CHARS) {
			words.addAll(generate(word + c));
		}
		return words;
	}

	public int solution(String word) {

		return generate("").indexOf(word);
	}



	///////

	public List<String> generate1(String word, List<String> words) {

		words.add(word);
		// 종료조건 - 길이가 5가 되면 끝
		if(word.length() == 5) return words;

		for (char c  : CHARS) {

			generate1(word + c, words);
		}
		//반복문

		return words;

	}

	public int solution1(String str) {

		List<String> words = new ArrayList<>();

		generate1("", words);

		return words.indexOf(str);
	}
}
