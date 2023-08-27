package study;

import java.util.Arrays;
import java.util.Comparator;

public class leetcode646 {

	public int findLongestChain(int[][] pairs) {

		int answer = 0;

		int[][] sotredPairs = Arrays.stream(pairs)
				.sorted(Comparator.comparingInt(i -> i[1]))
				.toArray(int[][]::new);

		int secondIndex = sotredPairs[0][1];

		for (int i = 1 ; i < sotredPairs.length; i++) {
			if (secondIndex <= sotredPairs[i][0]) answer++;
		}
		return answer;
	}
}
