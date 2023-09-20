package java.study.solved;

public class leet338 {
	public int[] countBits(int n) {
		int[] ans = new int[n + 1];

		for (int i = 0; i <= 5; i++) {
			String bit = Integer.toString(i, 2).replace("0","");
			ans[i] = bit.length();
		}

		return ans;
	}
}
