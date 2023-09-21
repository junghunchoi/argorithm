package javaalgorithm.Programmers.Book.chapter10;

import java.util.Arrays;

//https://school.programmers.co.kr/learn/courses/30/lessons/43105
public class 정수삼각형 {

	/* 1) 2023.07.26

	 */

	private static final int[][] mem = new int[501][501];

	int count = 0;

	public static void main(String[] args) {
		정수삼각형 cons = new 정수삼각형();

		System.out.println(cons.solution(new int[][]{{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}}));
	}

	private int max(int x, int y, int[][] triangle) {
//		System.out.println("max("+x+","+ y+")  " + "mem[x][y] : " + mem[x][y] );
		if (y == triangle.length) return 0;// 끝까지가면 0리턴

		if (mem[x][y] != -1) return mem[x][y]; // x축, y축 값이있으면 해당 부분 리턴
		System.out.println("x : " + x + " y : " + y );

		return mem[x][y] = triangle[y][x] + Math.max(max(x + 1, y, triangle), max(x, y + 1, triangle));
	}

	public int solution(int[][] triangle) {
		for (int[] row : mem) {
			Arrays.fill(row, -1);
		}
		return max(0, 0, triangle);
	}
}
