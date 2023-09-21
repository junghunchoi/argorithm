package javaalgorithm.Programmers.Book.chapter6;

import java.util.HashSet;

//https://school.programmers.co.kr/learn/courses/30/lessons/64064
public class 불량_사용자 {

	////////
	String[] userIds;
	String[] bannedIds;
	HashSet<HashSet<String>> result = new HashSet<>();

	public static void main(String[] args) {
		불량_사용자 con = new 불량_사용자();
		String[] userID = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
		String[] banID = {"abc1**", "fr***"};


		System.out.println(con.solution(userID, banID)); // 우의 경우의 수를 반복한다.
	}

	public int solution(String[] user_id, String[] banned_id) {

		userIds = user_id;
		bannedIds = banned_id;

		dfs(new HashSet<>(), 0);

		return result.size();
	}

	void dfs(HashSet<String> set, int depth) { // 저장할 자료구조와 depth는 기본적으로 들어가야한다.
		/*
		1) 주어진 밴목록만큼 순회를 하면 끝낸다.
		2) 주어진 userid만큼 반복을 한다
		2-1) 밴리스트안에 이미 사용자 id가 들어있다면 반복 졸요
		2-2) 주어진 제약조건에 부합하다면 dfs를 반복한다.
		 */

		if (depth == bannedIds.length) {
			result.add(set);
			return;
		}

		for (int i = 0; i < userIds.length; i++) {
			if (set.contains(userIds[i])) {
				continue;
			}

			if (check(userIds[i], bannedIds[depth])) {
				set.add(userIds[i]);
				dfs(set, depth + 1);
				set.remove(userIds[i]);
			}
		}

	}

	private boolean check(String userId, String bannedId) {

		if (userId.length() != bannedId.length()) {
			return false;
		}

		for (int i = 0; i < bannedId.length(); i++) {
			if (bannedId.charAt(i) != '*' && bannedId.charAt(i) != userId.charAt(i)) return false;
		}

		return true;
	}
}
