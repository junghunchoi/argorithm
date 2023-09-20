package java.study;

public class leet2815 {

	public static void main(String[] args) {
		leet2815 con = new leet2815();

		System.out.println(con.maxSum(new int[]{51,71,17,24,42}));
	}

	public int maxSum(int[] nums) {

		int max = 0;
		/*
		내 풀이
		1) 인덱스별로 문자열로 변환한 후 앞뒤 숫자를 다시 짜게서 더한다.
		2) 반복문을 돌면서 값이 같다면 변수에 최대값을 업데이트 하면서 반환한다.

		--
		풀이
		1) 인트형은 자리별로 값을 구하기 위해선 10으로 나누거나 나머지를 구해서 문제를 푼다.
		2)
		 */
		for (int i = 0; i < nums.length; i++) {
			for (int j = i+1; j < nums.length; j++) {
				if(maxDigit(nums[i]) == maxDigit(nums[j])) max = Math.max(max, nums[i] + nums[j]);
			}
		}


		return max == 0 ? -1 : max;

	}

	int maxDigit(int n) {
		int a = n;
		int max = 0;
		while (a != 0) {
			int b = a%10;
			max = Math.max(max, b);
			a /= 10;
		}
		return max;
	}
}
