package Programmers.Book.chapter6;

import java.util.HashSet;
import java.util.LinkedHashSet;

//https://school.programmers.co.kr/learn/courses/30/lessons/64064
public class 불량_사용자 {
// 쉬운 dfs 문제를 통해 이해해야한다. ㅜㅜ
	static HashSet<HashSet<String>> answer;

	public int solution(String[] user_id, String[] banned_id) {
		answer = new HashSet<>();
		dfs(new LinkedHashSet<>(), user_id, banned_id);


		return answer.size();
	}

	private void dfs(HashSet<String> hs, String[] user_id, String[] banned_id) {
		System.out.println("dfs in " + hs.toString());
		System.out.println("answer : " + answer.toString());
		int count = 0;
		if (hs.size() == banned_id.length) {
			if (isBanList(hs, banned_id)) {
				answer.add(new HashSet<>(hs));
			}
			return;
		}
		for (String userID : user_id) {
			System.out.println("userid : " + userID + " " + ++count);
			if (hs.add(userID)) {
				dfs(hs, user_id, banned_id);
				hs.remove(userID);
			}
		}
	}

	private static boolean isBanList(HashSet<String> hs, String[] banned_id) {
		int idx = 0;
		for (String userID : hs) {
			String banID = banned_id[idx++];
			if (userID.length() != banID.length()) {
				return false;
			}
			for (int i = 0; i < banID.length(); i++) {
				if (banID.charAt(i) == '*') {
					continue;
				}
				if (userID.charAt(i) != banID.charAt(i)) {
					return false;
				}
			}
		}
		return true;
	}
}
