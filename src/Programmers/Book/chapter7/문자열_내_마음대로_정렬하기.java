package Programmers.Book.chapter7;


import java.util.Arrays;

//https://school.programmers.co.kr/learn/courses/30/lessons/12915
public class 문자열_내_마음대로_정렬하기 {

	/*
		2023.07.12
	*/


	public String[] solution(String[] arr, int n) {

		return Arrays
				.stream(arr)
				.sorted((v1, v2) -> {
					if (v1.charAt(n) != v2.charAt(n)) {
						return v1.charAt(n) - v2.charAt(n); // 오름차순 정렬

					}
					return v1.compareTo(v2);
				})
				.toArray(String[]::new);

	}

}
