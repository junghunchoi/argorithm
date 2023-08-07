package Programmers.Book.chapter11;


import java.util.Arrays;
import java.util.Stack;

//https://school.programmers.co.kr/learn/courses/30/lessons/42584
public class 주식가격 {

	public static void main(String[] args) {

		solution(new int[]{1, 4, 5, 2, 3}); // 4, 2, 1, 1, 0
	}

	public static int[] solution(int[] prices) {
		int[] answer = new int[prices.length];
		Stack<Integer> stack = new Stack<>();


		for (int i = 0; i < prices.length; i++) {
			while (!stack.isEmpty() && prices[stack.peek()] > prices[i]) { // 스택 제일 앞에 쌓인 것보다 작으면 떨어진거니까
				int index = stack.pop();	// 스택의 제일 머리부분을 꺼낸다.
				answer[index] = i - index;     // 정답에 index -1을 넣는다?
			}

			stack.push(i);				// 스택에 인덱스 값을 넣는다.
			System.out.println("i: " + i + "      " + stack.toString());
		}


		System.out.println(Arrays.toString(answer));

		while (!stack.isEmpty()) {
			int index = stack.pop();
			answer[index] = prices.length - index - 1; //
		}

		return answer;
	}




}
