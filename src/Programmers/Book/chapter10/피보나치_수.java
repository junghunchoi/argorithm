package Programmers.Book.chapter10;

import java.util.Arrays;

public class 피보나치_수 {

	private static final int[] mem = new int[100001];// 문제의 제한사항의 크기만큼 배열을 생성한다.
	int count = 0;
	public static void main(String[] args) {

		피보나치_수 cons = new 피보나치_수();

		System.out.println(cons.solution(3));

	}

	private int finonacci(int n) {
		System.out.println(++count);
		System.out.println(n);
		if(mem[n]!=-1) return mem[n]; // 배열에 지정했던 값이 있는 경우 그대로 리턴

		if(n==0||n==1) return n; // 0 ,1 일 때 값이 없으므로 넣었던 값 그대로 리턴.

		return mem[n] = (finonacci(n - 1) + finonacci(n - 2)) % 1234567; // 파보나치 있는 값을 리턴.
	}

	private int solution(int n) {

		Arrays.fill(mem,-1);

		for (int i = 0; i <= n; i++) {

			finonacci(i);
		}

		return finonacci(n);
	}



}
