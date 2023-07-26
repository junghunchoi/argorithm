package Programmers.Book.chapter10;

import java.util.Arrays;

// https://school.programmers.co.kr/learn/courses/30/lessons/42898
public class 등굣길 {

	/* 1) 2023.07.26

	 */

	// 배열만큼 이동해야한다.
	// 물웅덩이를 만났을 경우 다른 곳으로 움직여야한다.
	//

	public static void main(String[] args) {

		등굣길 cons = new 등굣길();
		cons.solution(4, 3, new int[][]{{2, 3},{4,2}});

	}

	private final int[][] mem = new int[101][101];

	private int solution(int m, int n, int[][] puddles) {

		/* 배열 및 물 웅덩
		* */

		for (int[] i : mem) {
			Arrays.fill(i,-1);
		}

		boolean[][] isPuddle = new boolean[n + 1][m + 1];

		for (int[] p : puddles) {
			System.out.println("p[1] : " + p[1]  + "p[0]" + p[0] );
			isPuddle[p[1]][p[0]] = true;
		}

//		for (boolean[] subArray : isPuddle) {
//			for (boolean b : subArray) {
//				System.out.print(b ? 1 : 0);
//			}
//			System.out.println();
//		}
		return count(1, 1, m, n, isPuddle);
	}

	// 경로가 몇개인지 카운트
	private int count(int x, int y, int w, int h, boolean[][] isPuddle) {

		// 이동한게 배열의 크기보다 크면 리턴
		if(x>w || y>h) return 0;

		// 이동했을 때 물웅덩이면 리턴
		if(isPuddle[y][x]) return 0;

		// 코스가 뭔가가 있으면 했던 배열을 리턴
		if(mem[x][y] != -1) return mem[x][y];

		// 목적지까지 갔으면 1을 반환.
		if(x==w&&y==h) return 1;

		int total = count(x + 1, y, w, h, isPuddle) + count(x, y + 1, w, h, isPuddle);

		return mem[x][y] = total % 1000000007;
	}


	private int solution1(int m, int n, int[][] puddles) {

		int answer = 0 ;



		return answer%1000000007;
	}

}
