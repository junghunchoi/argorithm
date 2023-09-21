package javaalgorithm.study;

import java.util.Arrays;

//https://leetcode.com/problems/koko-eating-bananas/
public class leet875 {

	public static void main(String[] args) {
		int[] piles = {30, 11, 23, 4, 20};
		int h = 5;

		leet875 cons = new leet875();
		System.out.println(cons.minEatingSpeed2(piles, h));
	}

	public int minEatingSpeed2(int[] piles, int h) {
		Arrays.sort(piles);

		int start = 0;
		int end = piles[piles.length - 1];

		while (start < end) {
			int mid = (start + end) / 2;
			int takeTime = 0;

			for (int banana : piles) {
				takeTime += Math.ceil((double) banana / mid);
			}
			if (takeTime >= h) {
				start = mid + 1; //시간이 모자라면 중간보다 넘어서 셋팅
			}
			System.out.println("start : " + start + " end : " + end + "mid : " + mid + " takeTime : " + takeTime);

			if (takeTime < h) {
				end = mid;
			}
		}
		return start;
	}
}
