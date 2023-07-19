package study;


import java.util.ArrayList;
import java.util.List;

public class 소수의_연속합 {

	public static void main(String[] args) {

		소수의_연속합 con = new 소수의_연속합();

		System.out.println(con.solution(41));

	}

	public int solution(int n) {
		List<Integer> primeNum = new ArrayList<>();

		for (int i = 0; i < 41; i++) {
			if (isPrime(i)) primeNum.add(i);
		}

		System.out.println("size : " + primeNum.size());
		int count = 0;

		int start = 0;
		int end = 0;

		while (true) {

			int sum = 0;

			for (int i = start; i <= end; i++) {
				sum += primeNum.get(i);
			}

			int size = primeNum.size();

			System.out.println("sum : " + sum + " start : " + start + " end : " + end + " count : " + count);
			if (sum == n) {
				count++;
				end++;
			} else if (sum < n) {
				end++;
			} else {
				start++;
			}


			if (start == size || end == size || start > end) break;

		}

		return count;
	}


	private boolean isPrime(int n) {
		if (n <= 1) return false;
		if (n == 2) return true;
		if (n % 2 == 0) return false;

		for (int i = 3; i * i <= n; i++) {
			if (n % i == 0) return false;
		}

		return true;
	}
}
