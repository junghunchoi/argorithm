package java.Programmers.Book.chapter12;

//https://school.programmers.co.kr/learn/courses/30/lessons/43165
public class 타겟_넘버 {

	/*
		1) 2023.08.11 2회차까지만 풀어보고 시마이이	 */

	int answer = 0;

	public int solution(int[] numbers, int target) {
		dfs(numbers,target,0,0);

		return answer;
	}

	public void dfs(int[] numbers, int target, int curr, int depth) {
		if (depth == numbers.length) {
			if (target == curr) answer++;
		} else {
			dfs(numbers,target,curr+numbers[depth],depth+1);
			dfs(numbers,target,curr-numbers[depth],depth+1);
		}
	}
}
