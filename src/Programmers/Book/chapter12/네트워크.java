package Programmers.Book.chapter12;

import java.util.Stack;

//https://school.programmers.co.kr/learn/courses/30/lessons/43162
public class 네트워크 {
	/*
	1) 2023.08.28
	 */

	public static void main(String[] args) {
		네트워크 con = new 네트워크();

		System.out.println(con.solution(3, new int[][]{{1,1,0},{1,1,0},{0,0,1}}));
	}



	public int solution(int n, int[][] computers) {
		boolean[] isVisited = new boolean[n];
		int answer = 0;

		for (int i = 0; i < n; i++) {
			if(isVisited[i]) continue;
			visitAll(i,computers,isVisited);
			answer++;
		}

		return answer;
	}

	private void visitAll(int computer, int[][] computers,boolean[] isVisited) {
		/*
		dfs로 연결된 컴퓨터의 갯수를 구하는 메서드
		 */

		//1. 연결된 모든 노드를 찾아야한다. 진행하고자하는 스택을 선언
		Stack<Integer> stack = new Stack<>();
		stack.push(computer);

		//2. 순회하며 방문할 상태를 스택에서 가져온다.
		while (!stack.isEmpty()) {

			int c = stack.pop();
			System.out.println("c : " + c + "    " + stack.toString());
			if(isVisited[c]) continue;
			isVisited[c] = true;

			// 3. 인접 노드를 순회하며 후보상태를 만들 수 있다.
			for (int i = 0; i < computers[c].length; i++) {
				//4. 현재노드와 연결된 노드여야함. 아니라면 제외
				if(computers[c][i] == 0) continue;

				//5. 해당되는 노드를 스택에 넣어 연결
				stack.push(i);
			}
			System.out.println(stack.toString());
		}

	}
}
