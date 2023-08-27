package Programmers.Book.chapter10;

import java.util.Arrays;

// https://school.programmers.co.kr/learn/courses/30/lessons/42898
public class 등굣길 {
	/*
	배운 것
	1) dp에서 자료구조의 크기는 어떻게 설정을 해야하는가.
	2) 0,0 시작일 때와 1,1시작할 때는 천치차이다. 확실히 이해하고 넘어가야한다.

	 */
	/* 1) 2023.08.22

	 */

	private final int[][] mem = new int[101][101];

	public static void main(String[] args) {
		등굣길 cons = new 등굣길();
		System.out.println(cons.solution(4, 3, new int[][]{{2, 2}}));
	}

	private int solution(int w, int h, int[][] puddles) {
		boolean[][] isPuddle = new boolean[h+1][w+1];

		for (int[] arr : mem) {
			Arrays.fill(arr, -1);
		}


		for (int[] puddle : puddles) {
			isPuddle[puddle[1]][puddle[0]] = true;
		}

		return count(1, 1, w, h, isPuddle);
	}

	private int count(int x, int y, int w, int h, boolean[][] isPuddle) {
		if(x>w) return 0;
		if(y>h) return 0;
		if(isPuddle[y][x]) return 0;
		if(mem[x][y] != -1) return mem[x][y];
		if(x==w && y==h) return 1;

		int total = count(x + 1, y, w, h, isPuddle) + count(x, y + 1, w, h, isPuddle);
		System.out.println("total : " + total + " x : " + x + " y : " + y);
		return mem[x][y] = total % 1000000007;
	}


}
