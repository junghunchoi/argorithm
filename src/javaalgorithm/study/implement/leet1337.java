package javaalgorithm.study.implement;

import java.util.Arrays;

public class leet1337 {

	public static void main(String[] args) {

	}

	public int[] kWeakestRows(int[][] mat, int k) {

		int[] ans = new int[k];
		int[][] sortedArr = new int[mat.length][2];


		for (int i = 0; i < mat.length; i++) {
			int count = (int)Arrays.stream(mat[i]).filter(soldier -> soldier == 1).count();
			sortedArr[i][0] = i;
			sortedArr[i][1] = count;

		}

		Arrays.sort(sortedArr, (a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);

		for (int i = 0; i < sortedArr.length; i++) {
			if(i == k) break;
			ans[i] = sortedArr[i][0];
		}

		return ans;
	}
}
