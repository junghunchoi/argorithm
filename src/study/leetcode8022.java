package study;

public class leetcode8022 {
	/*
		8월4주차 1
		 */

	/*
		저장된 배열에서 target의 값을 뺸다음에 구해야하나?
	 */
	public static void main(String[] args) {
		leetcode8022 con = new leetcode8022();

		System.out.println(con.minimumPossibleSum(16, 6));
	}

	public long minimumPossibleSum(int n, int target) {
		long k = target / 2;
		if (n <= k)
			return 1L * n * (n + 1) / 2;

		return k * (k + 1) / 2 + (target + target + n - k - 1) * (n - k) / 2;

//		if (n == 1) return 1;
//
//		int[] answer = new int[n];
//		int inputNum = 1;
//		answer[0] = inputNum++;
//
//		for (int i = 1; i < n; i++) {
//			if (i >= target) {
//				answer[i] = inputNum++;
//			} else {
//				for (int j = 0; j < i; j++) {
//					if(answer[j]+inputNum == target) inputNum++;
//				}
//				answer[i] = inputNum++;
//			}
//
//		}
//
//		Arrays.stream(answer)
//				.forEach(System.out::println);
//
//		return Arrays.stream(answer)
//				.sum();
	}


}
