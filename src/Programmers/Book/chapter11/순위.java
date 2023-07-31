package Programmers.Book.chapter11;

import java.util.Arrays;

//https://school.programmers.co.kr/learn/courses/30/lessons/49191
public class 순위 {
	// !!! 트리문제는 노드간의 관계를 문제로 풀며 2차원 배열을 통해 해결한다.
	// 2차원 배열에 승패를 기록한 후 기록된 데이터를 바탕으로 문제를 푼다.

	public static void main(String[] args) {

		순위 con = new 순위();

		int[][] arr = {{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}};


		System.out.println(con.solution(5, arr));

	}

	// 이긴 선수의 수를 세기 위한 화살표 방향으로 진행하며 만나는 노드의 갯수 확인
	private int countForward(int u, boolean[][] graph, boolean[] isvisted) {

		int count = 1;

		for (int v = 0; v < graph[u].length; v++) {
			// u와v는 연결되어 있고 이전에 방문한적 없으면 진행할 수 있음
			if (!graph[u][v] || isvisted[v]) continue;
			isvisted[v] = true;
			count += countForward(v, graph, isvisted);
		}
		return count;
	}

	// 진경우를 확인하기 위한 메소드
	private int countBackward(int u, boolean[][] graph, boolean[] isvisted) {

		int count = 1;

		for (int v = 0; v < graph[u].length; v++) {
			// u와v는 연결되어 있고 이전에 방문한적 없으면 진행할 수 있음
			if (!graph[v][u] || isvisted[v]) continue;
			isvisted[v] = true;
			count += countForward(v, graph, isvisted);
		}

		return count;
	}

	public int solution(int n, int[][] result) {

		boolean[][] graph = new boolean[n][n];

		for (int[] edge : result) {
			int u = edge[0] - 1;
			int v = edge[1] - 1;
			graph[u][v] = true;

		}

		int count = 0;

		for (int u = 0; u < n; u++) {
			int wins = countForward(u, graph, new boolean[n]) - 1;
			int lose = countBackward(u, graph, new boolean[n]) - 1;

			if (wins + lose + 1 == n) {
				count++;
			}
		}

		System.out.println(Arrays.deepToString(graph));
		return count;
	}
}
