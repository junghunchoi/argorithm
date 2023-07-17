package Programmers.Book.chapter10;

import java.util.Arrays;

// https://school.programmers.co.kr/learn/courses/30/lessons/42898
public class 등굣길 {

	// 배열만큼 이동해야한다.
	// 물웅덩이를 만났을 경우 다른 곳으로 움직여야한다.
	//

	public static void main(String[] args) {

		등굣길 cons = new 등굣길();
		cons.solution(4, 3, new int[][]{{2, 3},{4,2}});

	}

	private final int[][] mem = new int[101][101];

	private int solution(int m, int n, int[][] puddles) {

		for (int[] i : mem) {
			Arrays.fill(i,-1);
		}

		boolean[][] isPuddle = new boolean[n + 1][m + 1];

		for (int[] p : puddles) {
			System.out.println("p[1] : " + p[1]  + "p[0]" + p[0] );
			isPuddle[p[1]][p[0]] = true;
		}

		for (boolean[] subArray : isPuddle) {
			for (boolean b : subArray) {
				System.out.print(b ? 1 : 0);
			}
			System.out.println();
		}
		return count(1, 1, m, n, isPuddle);
	}

	private int count(int x, int y, int w, int h, boolean[][] isPuddle) {
		if(x>w || y>h) return 0;
		if(isPuddle[y][x]) return 0;

		if(mem[x][y] != -1) return mem[x][y];
		if(x==w&&y==h) return 1;

		int total = count(x + 1, y, w, h, isPuddle) + count(x, y + 1, w, h, isPuddle);

		return mem[x][y] = total % 1000000007;
	}


}
