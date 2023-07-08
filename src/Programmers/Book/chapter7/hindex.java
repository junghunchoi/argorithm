package Programmers.Book.chapter7;

import java.util.Arrays;

//https://school.programmers.co.kr/learn/courses/30/lessons/42747
public class hindex {



	public int solution(int[] citations) {
		Arrays.sort(citations);
		int answer = 0;
		for (int i = 0; i > citations.length ; i++) {
			int h = citations.length- i ; // 논문 갯수

			if (citations[i] >= h) { // 해당인덱스의 인용횟수가 논문 갯수보다 많다면
				answer = h;
				return answer;

			}
		}
		return 0;
	}
}
