package javaalgorithm.study;

public class leet1658 {

	public static void main(String[] args) {
		leet1658 con = new leet1658();
		System.out.println(con.minOperations(new int[]{1, 1, 4, 2, 3}, 5));

	}

	public int minOperations(int[] nums, int x) {
		int sum = 0;
		for (int num: nums) sum += num;

		int maxLength = -1, currSum = 0;

		for (int l=0, r=0; r<nums.length; r++) {
			currSum += nums[r];
			while (l <= r && currSum > sum - x) currSum -= nums[l++];
			if (currSum == sum - x) maxLength = Math.max(maxLength, r-l+1);
		}

		return maxLength == -1 ? -1 : nums.length - maxLength;

	}
}
