package Programmers.Book.chapter6;

import java.util.HashSet;
import java.util.LinkedHashSet;

//https://school.programmers.co.kr/learn/courses/30/lessons/64064
public class 불량_사용자 {

	public static void main(String[] args) {
		불량_사용자 con = new 불량_사용자();
		String[] userID = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
		String[] banID = {"fr*d*", "abc1**"};
		con.solution(userID, banID);
	}


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

		// Set의 사이즈가 제제목록과 동일하면
		if (hs.size() == banned_id.length) {
			//밴 리스트의 조건과 동일하면
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
			// 길이가 다른 경우 틀린거지
			if (userID.length() != banID.length()) {
				return false;
			}

			for (int i = 0; i < banID.length(); i++) {
				//*의 위치가 같으면 지나감
				if (banID.charAt(i) == '*') {
					continue;
				}
				//일단 다르면 리턴
				if (userID.charAt(i) != banID.charAt(i)) {
					return false;
				}
			}
		}
		return true;
	}
}
