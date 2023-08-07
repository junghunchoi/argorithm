package study;

import java.util.List;

public class VisitRoom {

	public boolean canVisitAllRooms(List<List<Integer>> rooms) {

		int n = rooms.size();
		boolean[] visited = new boolean[n];
		int ans = helper(rooms, visited, 0,n);
		return ans == n;
	}

	// 들어갈 수 있는 방을 리턴하는 함수
	public int helper(List<List<Integer>> rooms, boolean[] visited, int curr, int n) {

		/*
		방문했으면 종료
*/
		if(visited[curr]) return 0;

		visited[curr] = true;
		int answer = 1;

		for (int i = 0; i < rooms.size(); i++) {
			// 돌면서 키가 다음방에 쓸 수 있으면 리턴을 한다.

			answer += helper(rooms, visited, i, n);

		}
		return answer;
	}

}
