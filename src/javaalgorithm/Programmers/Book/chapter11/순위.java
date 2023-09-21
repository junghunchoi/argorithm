package javaalgorithm.Programmers.Book.chapter11;

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

	private int countForward(int u, boolean[][] graph, boolean[] isVisited) {
		int count = 1;

		for (int v = 0; v < graph[u].length; v++) {
			if (!graph[u][v] || isVisited[v]) continue;
			isVisited[v] = true;
			count += countForward(v, graph, isVisited);
		}

		return count;
	}

	// 진거를 확인해
	private int countBackward(int u, boolean[][] graph, boolean[] isVisited) {
		int count = 1;

		for (int v = 0; v < graph.length; v++) { // 그래프의 갯수만큼 순회

			if(u==4){
				System.out.println(Arrays.toString(isVisited));
				System.out.println("v : " + v + " isvisit : " + isVisited[v] + " count : " + count );
			}


			if (!graph[v][u] || isVisited[v]) continue;
			if(u==4){
				System.out.println(Arrays.toString(isVisited));
				System.out.println("v : " + v + " isvisit : " + isVisited[v] + " count : " + count );
			}
			isVisited[v] = true;
			count += countBackward(v, graph, isVisited); // 0번째에서
		}

		return count;
	}

	public int solution(int n, int[][] results) {
		boolean[][] graph = new boolean[n][n];
		for (int[] edge : results) {
			int u = edge[0] - 1;
			int v = edge[1] - 1;
			graph[u][v] = true;
		}

		int count = 0;

		for (int u = 0; u < n; u++) {
			int wins = countForward(u, graph, new boolean[n]) - 1;
			int loses = countBackward(u, graph, new boolean[n]) - 1;

//			System.out.println(" u : " +u + " win : " + wins + " loses : " + loses);
			if (wins + loses + 1 == n) {
				count++;
			}
		}

//		System.out.println(Arrays.deepToString(graph));


		return count;
	}
}
