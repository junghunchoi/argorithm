package java.study.solved;

import java.util.Arrays;

public class leet287 {


	public int findDuplicate(int[] nums) {
		int[] copy = nums;
		Arrays.sort(copy);
		int i = copy[0];

		for (int j = 1; j < copy.length; j++) {
			if(copy[j] == i) return copy[j];
			i = copy[j];
		}
		return 0;
	}
}
