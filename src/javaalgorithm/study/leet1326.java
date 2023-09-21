package javaalgorithm.study;

import java.util.Arrays;

//https://leetcode.com/problems/minimum-number-of-taps-to-open-to-water-a-garden/
public class leet1326 {

	public static void main(String[] args) {
		leet1326 con = new leet1326();

		System.out.println(con.minTaps(4, new int[]{2,2,1,1,0})); // 1
	}

	public int minTaps(int n, int[] ranges) {

		int[] nums = new int[n + 1];

		for (int i = 0; i <= n; ++i) {
			int l = Math.max(0, i - ranges[i]);
			int r = Math.min(n, i + ranges[i]);
			nums[l] = Math.max(nums[l], r - l);
		}
		System.out.println(Arrays.toString(nums));
		int ans = 0;
		int end = 0;
		int farthest = 0;

		for (int i = 0; i < n; i++) {
			farthest = Math.max(farthest, i + nums[i]);
			if (i == end) {
				++ans;
				end = farthest;
			}
		}

		return end == n ? ans : -1;
	}
}
