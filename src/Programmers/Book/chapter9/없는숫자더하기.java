package Programmers.Book.chapter9;

//https://school.programmers.co.kr/learn/courses/30/lessons/86051
public class 없는숫자더하기 {

	public static int solution(int[] arr) {

		int answer = 0;

		for (int i : arr) {
			answer += i;
		}

		return 45 - answer;

	}


}
