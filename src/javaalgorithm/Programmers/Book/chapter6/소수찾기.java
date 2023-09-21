package javaalgorithm.Programmers.Book.chapter6;

import java.util.HashSet;
import java.util.Set;

//https://school.programmers.co.kr/learn/courses/30/lessons/42839
//lv2
public class 소수찾기 {
	/*

	 */


	public static void main(String[] args) {
		소수찾기 con = new 소수찾기();

		con.solution("1231");

	}

	public int solution(String nums) {

		Set<Integer> set = new HashSet<>();
		int[] numbers = nums.chars().map(i-> i-'0')
				.toArray();

		makeSet(0,new boolean[numbers.length],numbers,set);
		return set.size();

	}

	public void makeSet(int acc,boolean[] isUsed,int[] numbers, Set<Integer> set) {
		if(isPrime(acc)) set.add(acc);

		for (int i = 0; i < numbers.length; i++) {
			if(isUsed[i]) continue;

			int nextAcc = acc * 10 + numbers[i];
			isUsed[i] = true;
			makeSet(nextAcc,isUsed,numbers,set);
			isUsed[i] = false;
		}


	}

	public boolean isPrime(int number) {
		if(number <= 1) return false;
		if(number > 2 && number % 2 == 0) return false;

		for (int i = 2; i * i<= number; i++) {
			if(number % i == 0) return false;
		}
		return true;
	}
}
