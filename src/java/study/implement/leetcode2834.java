package java.study.implement;

import java.util.HashSet;
import java.util.Set;

public class leetcode2834 {
	/*
		1) 8월4주차

		연속해서 숫자가 들어가야하는 문제는 무조건 fori를 써야한다.
		 */
	public static void main(String[] args) {
		leetcode2834 con = new leetcode2834();

		System.out.println(con.minimumPossibleSum(16, 6));
	}

	public long minimumPossibleSum(int n, int target) {
		Set<Integer> set = new HashSet<>();
		long ans = 0;

		for (int i = 1; set.size() < n; ++i) {
			if (!set.contains(target - i)) {
				set.add(i);
				ans += i;
			}
		}
		return ans;
	}
}