package javaalgorithm.study;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


//https://leetcode.com/problems/keys-and-rooms/description/?envType=study-plan-v2&envId=leetcode-75
public class VisitRoom {

	/* 1) 08.03
		- 이런 알고리즘에서는 어떤식으로 접근해야하는가? recursive한 함수를 사용하기 위해 어떤식으로 흘러가야하는지 머리속으로 계산이 되어야한다.
	 */

	static int count = 0;

	public static void main(String[] args) {
		VisitRoom con = new VisitRoom();


		List<List<Integer>> arr = Arrays.asList(Arrays.asList(1),Arrays.asList(3,0,1),Arrays.asList(2),Arrays.asList(0));
		System.out.println(con.canVisitAllRooms(arr));




	}

	public boolean canVisitAllRooms(List<List<Integer>> rooms) {

		int n = rooms.size();
		boolean[] visited = new boolean[n];
		int ans = helper(rooms, visited, 0,n);


		// 주어진 방의 갯수와 방문한 방의 갯수를 비교한다.
		List<Integer> visitList = new ArrayList<>();
		recursiveVisit(visitList, rooms, 0);// 0번방부터 시작
		if (visitList.size() == rooms.size()) {
			return true;
		}
		else if(visitList.size() != rooms.size()) return false;

		return ans == n;
	}

	// 들어갈 수 있는 방을 리턴하는 함수
	public int helper(List<List<Integer>> rooms, boolean[] visited, int curr, int n) { // n은 방의 크기?
		count++;
		System.out.println("visited : " + visited[curr] + " curr : " + curr);
		if(visited[curr]) {
			return 0;
		}
		// 방에 들렸으면 돌아간다.
		visited[curr] = true;
		//안들렸으니 들어간후 체크한다.
		int ans = 1;

		// 들린방의 키뭉치만큼 반복한다.
		for(int i = 0; i<rooms.get(curr).size(); i++) {
			System.out.println("size: " + rooms.get(curr).size());
			List<Integer> keys = rooms.get(curr); // 들어갈려하는 방의 인덱스 키뭉치를 반환하는거야?
			ans += helper(rooms, visited, keys.get(i), n);
		}
//		System.out.println("visited : " + visited[curr] + " curr : " + curr + " n : " + n + " answer : " + ans);
		return ans;
	}


	private void recursiveVisit(List<Integer> visitList, List<List<Integer>> rooms, int n) {

		visitList.add(n);

		List<Integer> list = rooms.get(n);

		for (int idx : list) {
			if (!visitList.contains(idx)) {
				recursiveVisit(visitList, rooms, idx);
			}
		}

	}
}
