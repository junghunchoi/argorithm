package java.study;


import java.util.ArrayList;
import java.util.List;

//https://code-lab1.tistory.com/134
public class 소수의_연속합 {

	/* 1) 2023.07.20 30분
	*/

	public static void main(String[] args) {

		소수의_연속합 con = new 소수의_연속합();

		System.out.println(con.addsolution(41));

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


	public int addsolution(int n) {

		int start = 0;
		int end = 1;
		int count = 0;



		List<Integer> arr = new ArrayList<>();

		for (int i = 0; i <= n; i++) {
			if(addisPrime(i)) arr.add(i);
		}

		while (start <= end) {

			int sum = 0;

//			int mid = (start + end) / 2;

			for (int i = start; i < end; i++) {
				sum += arr.get(i);
			}
			System.out.println(arr.toString());
			System.out.println("start : " + start + " end : " + end + " sum : " + sum);

			if(sum==n) count++;


			if(sum<=n && end != arr.size()) end++;
			else start++;

//			if(end>arr.size()) break;

		}



		return count;

	}

	private boolean addisPrime(int n) {

		if (n==1) return false;
		if(n==2) return true;
		if(n%2==0) return false;

		for (int i = 3; i < n; i++) {
			if(n%i==0) return false;
		}
		return true;

	}
}
