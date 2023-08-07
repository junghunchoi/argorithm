package study;

import java.util.Arrays;
import java.util.List;

public class day3 {

	public static void main(String[] args) {
		day3 con = new day3();

		System.out.println(con.canSplitArray(Arrays.asList(1,2,2), 4));
	}

	public boolean canSplitArray(List<Integer> A, int m) {
		for (int i = 0; i < A.size() - 1; ++i)
			if (A.get(i) + A.get(i + 1) >= m)
				return true;
		return false;
	}


//	public boolean divideArr(int[] nums, int m) {
//
//		boolean answer =false;
//
//		if (nums.length == 2 && Arrays.stream(nums).sum() >= m) {
//			answer = true;
//			return answer;
//		}
//
//		for (int i = 0; i < nums.length - 1; i++) {
//
//			int[] subArray = Arrays.copyOfRange(nums,i, (nums.length-1)+i);
//
//			if (Arrays.stream(subArray)
//					.sum() < m) {
//				answer = false;
//				continue;
//			}
//
//			answer = divideArr(subArray, m);
//		}
//
//		return answer;
//	}
}
