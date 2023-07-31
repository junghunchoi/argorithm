package Programmers.Book.chapter11;


import java.util.Stack;

//https://school.programmers.co.kr/learn/courses/30/lessons/42584
public class 주식가격 {

	// 다 풀면 리스트에서 삭제.

	public int[] solution(int[] prices) {
		int[] answer = new int[prices.length];

		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < prices.length; i++) {
			while (!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
				int index = stack.pop();
				answer[index] = i - index;
			}

			stack.push(i);
		}

		while (!stack.isEmpty()) {
			int index = stack.pop();
			answer[index] = prices.length - index - 1;
		}
		return answer;
	}
}
