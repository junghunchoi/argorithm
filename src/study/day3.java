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

}
