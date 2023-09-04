package study;

public class leet2707 {
	public static void main(String[] args) {
		leet2707 con = new leet2707();

		System.out.println(con.minExtraChar("leetcode", new String[]{"od","eet"}));

		/*
		  가장 오른쪽부터 문자열을 확인한다.
		  leetcod 일 경우 e만 남으므로 dp[7] = 1
		  leetco 일 경우 de만 남으므로 dp[6] = 2
		  leetc  일 경우 od가 제거되어 e만 남으므로 dp[5] = 1
		  leet 일 경우 ce만 남으므로 dp[4] = 2
		  lee 일 경우 tce만 남으므로 dp[3] = 3
		  le 일 경우 etce만 남으므로 dp[2] = 4
		  l 일 경우 eet가 제거되어 ce만 남으므로 dp[1] = 2
		  마지막 경우 lce만 남으므로 dp[0] = 3
		  --
		  dp[i] = Math.min(dp[i], dp[i + w.length()])의 경우
		  예를 들어 단어 사전에 eet와 eetc가 있을 경우 더 많이 지워지는 경우를 체크하기 위함
		 */
	}

	private int[] dp = new int[9];

	public int minExtraChar(String s, String[] dictionary) {
		int n = s.length();

		for (int i = n - 1; i >= 0; --i) {
			dp[i] = 1 + dp[i + 1];

			for (String w : dictionary) {
				if (i + w.length() <= n && s.substring(i, i + w.length())
						.equals(w)) {
					dp[i] = Math.min(dp[i], dp[i + w.length()]);
				}
			}
		}
		return dp[0];
	}
}
