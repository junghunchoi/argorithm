package study;

import java.util.Arrays;

public class day3 {

	public static void main(String[] args) {
		day3 con = new day3();

		System.out.println(con.canSplitArray(new int[]{2,2,1} , 4));
	}

	public boolean canSplitArray(int[] nums, int m) {
		// 배열을 계속해서 쪼게야한다.
		//
				return divideArr(nums, m);

	}

	public boolean divideArr(int[] nums, int m) {

		boolean answer =false;

		if (nums.length == 2 && Arrays.stream(nums).sum() >= m) {
			answer = true;
			return answer;
		}

		for (int i = 0; i < nums.length - 1; i++) {

			int[] subArray = Arrays.copyOfRange(nums,i, (nums.length-1)+i);

			if (Arrays.stream(subArray)
					.sum() < m) {
				answer = false;
				continue;
			}

			answer = divideArr(subArray, m);
		}

		return answer;
	}
}
