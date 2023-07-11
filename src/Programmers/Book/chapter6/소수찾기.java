package Programmers.Book.chapter6;

import java.util.*;
import java.util.stream.Collectors;

//https://school.programmers.co.kr/learn/courses/30/lessons/42839
public class 소수찾기 {
	//1. 앞이 0일경우는 안됨
	//2. 똑같은 숫자가 존재할 경우 카운트 하지 않음

	int count = 0;

	private Set<Integer> getPrime(int acc, List<Integer> numbers) {

		Set<Integer> primes = new HashSet<>();

		//종료조건
		if (numbers.isEmpty()) return primes; // 비어있을 때 아래 포문에서 실행이 안되기 때문에 굳이 필요없다.
		if (isPrime(acc)) primes.add(acc);


		// 점화식 구현
		for (int i = 0; i < numbers.size(); i++) {

			System.out.println("i : " + i + " acc : " + acc + "list : " + numbers.toString());
			int nextAcc = acc * 10 + numbers.get(i);
			List<Integer> nextNumbers = new LinkedList<>(numbers);
			nextNumbers.remove(i);
			primes.addAll(getPrime(nextAcc, nextNumbers));
		}

		return primes;
	}

	private boolean isPrime(int n) {
		if (n <= 1) return false;
		for (int i = 2; i * i < n; i++) {
			if (n % i == 0) return false;
		}
		return true;
	}

	// dfs 처럼 방문했던 노드는 스킵하고 다음 인덱스로 넘어가는 방법

	public void adGetPrime(int acc, int[] numbers, boolean[] isUsed,
	                       Set<Integer> primes) {
		if (isPrime(acc)) primes.add(acc);

		for (int i = 0; i < numbers.length; i++) {
			if (isUsed[i]) continue;
			int nextAcc = acc * 10 + numbers[i];

			isUsed[i] = true;
			adGetPrime(nextAcc, numbers, isUsed, primes);
			isUsed[i] = false;
		}
	}

	public int solution(String nums) {

		Set<Integer> primes = new HashSet<>();
		List<Integer> numbers = nums.chars().map(i -> i - '0').boxed().collect(Collectors.toList());

		return getPrime(0, numbers).size();

		/*getPrimes(0, numbers, new boolean[numbers.length], primes);
          return primes.size();
		* */
	}

	//

//	private Set<Integer> getPrime1(int acc, List<Integer> numbers) {
//
//		HashSet<Integer> set = new HashSet<>();
//
//		for (int i = 0; i < numbers.size(); i++) {
//
//			int prime =
//
//		}
//
//		return null;
//	}

}
