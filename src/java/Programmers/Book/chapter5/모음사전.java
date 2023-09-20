package java.Programmers.Book.chapter5;

import java.util.ArrayList;
import java.util.List;

//https://school.programmers.co.kr/learn/courses/30/lessons/84512
public class 모음사전 {

	/* 1) 2023.07.23 13분
	   2)

	 */
	private static final char[] CHARS = "AEIOU".toCharArray();

	public static void main(String[] args) {



	}



	public int solution(String word) {

		return generate("").indexOf(word);
	}

	private List<String> generate(String word) {
		List<String> list = new ArrayList<>();
		list.add(word);
		if (word.length() == 5) return list;

		for (char c : CHARS) {
			list.addAll(generate(word + c));
		}

		return list;

	}





}
