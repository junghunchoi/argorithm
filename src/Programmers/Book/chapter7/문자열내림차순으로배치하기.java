package Programmers.Book.chapter7;

import java.util.Arrays;
import java.util.Comparator;

//https://school.programmers.co.kr/learn/courses/30/lessons/12917
//복습x
public class 문자열내림차순으로배치하기 {

	public String solution(String s) {
		StringBuilder sb = new StringBuilder();

		String[] arr = s.split("");

		Arrays.sort(arr, Comparator.reverseOrder());

		for (String index : arr) {
			sb.append(index);
		}

		return sb.toString();
	}
}
