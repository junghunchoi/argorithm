package java.Programmers.Book.chapter10;

import java.util.Arrays;

//https://school.programmers.co.kr/learn/courses/30/lessons/12945
public class 피보나치_수 {

	/*   1) 2023.07.26
		 2) 2023.08.23
	 */

	private static final int[] mem = new int[100001];// 문제의 제한사항의 크기만큼 배열을 생성한다.

	public static void main(String[] args) {

		피보나치_수 cons = new 피보나치_수();

		System.out.println(cons.solution(10));

	}

	private int finonacci(int n) {
		if(n==1 || n==0) return n;
		if(mem[n] != -1) return mem[n];

		return mem[n] = finonacci(n-1) + finonacci(n-2);
	}

	private int solution(int n) {
		Arrays.fill(mem,-1);

		return finonacci(n);
	}
}
