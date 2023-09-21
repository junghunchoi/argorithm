package javaalgorithm.study.greedy;

import java.util.Arrays;

//https://leetcode.com/problems/minimum-replacements-to-sort-the-array/
public class leetcode2366 {

	public static void main(String[] args) {
		leetcode2366 con = new leetcode2366();

		System.out.println(con.minimumReplacement(new int[]{2,10,20,19,2}));
	}

	public long minimumReplacement(int[] nums) {
		long answer = 0;
		int n = nums.length;

		// 제일 마지막 -1 인덱스부터 역으로 순회한다.
		for (int i = n - 2; i >= 0; i--) {
			// 앞에께 더 크면 건너뛴다.
			if (nums[i] <= nums[i + 1]) {
				continue;
			}

			long numElements = (long)(nums[i] + nums[i + 1] - 1) / (long)nums[i + 1]; // 앞

			answer += numElements - 1;

			nums[i] = nums[i] / (int)numElements;

			System.out.println("i : " + i + " numelements : " + numElements + " answer : " + answer + " nums[i] : " + Arrays.toString(nums));
		}
//		System.out.println(Arrays.toString(nums));
		return answer;
	}
}
