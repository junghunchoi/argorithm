package javaalgorithm.study;

import java.util.List;
import java.util.TreeSet;

//https://leetcode.com/contest/weekly-contest-358/problems/minimum-absolute-difference-between-elements-with-constraint/
public class leet2817 {

	/* 1
	내 풀이
	1) 타임아웃이 나서 투 포인터로 문제를 풀려고 했다.

	다른 사람 풀이
	1) TreeSet 활용

	 */

	public static void main(String[] args) {
		leet2817 con3 = new leet2817();

		System.out.println(con3.minAbsoluteDifference(List.of(5,3,2,10,15), 1));
	}

	public int minAbsoluteDifference(List<Integer> nums, int x) {
		int ans = Integer.MAX_VALUE;

		TreeSet<Integer> s = new TreeSet<>();

		for (int i = x; i < nums.size(); ++i) {

			s.add(nums.get(i - x));

			Integer high = s.ceiling(nums.get(i));
			Integer low = s.floor(nums.get(i));

			if(high != null) ans = Math.min(ans, Math.abs(high - nums.get(i)));
			if(low != null) ans = Math.min(ans, Math.abs(low - nums.get(i)));
			System.out.println("i : " + i + " s : "+ s.toString() + " high : " + high + " low : " + low + " answer : " + ans + " nums " + nums.get(i));
		}

		return ans;
	}
}
