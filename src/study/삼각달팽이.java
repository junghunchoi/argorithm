package study;

import java.util.Arrays;

public class 삼각달팽이 {

	private static final int[] moveX = {0, 1, -1};
	private static final int[] moveY = {1, 0, -1};

	public static void main(String[] args) {

		Arrays.stream(solution(4)).forEach(value -> System.out.print(value + " "));
	}

	private static int[] solution(int n) {

		int[][] triangle = new int[n][n];

		int v = 1;
		int x = 0;
		int y = 0;
		int d = 0;

		while (true) {
			triangle[y][x] = v++;
			int nx = x + moveX[d];
			int ny = y + moveY[d];
			if (nx == n || ny == n || nx == -1 || ny == -1 || triangle[ny][nx] != 0) {
				d = (d + 1) % 3; // 아래(0) 오른쪽(1) 왼쪽위(2)
				nx = x + moveX[d]; // 현재의 위치를 업데이트한다.
				ny = y + moveY[d];
				if (nx == n || ny == n || nx == -1 || ny == -1 || triangle[ny][nx]!= 0) break;
			}
			x = nx;
			y = ny;

		}


		int[] result = new int[v - 1];
		int index = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= i; j++) {
//				if(triangle[i][j] == 0) continue;
				result[index++] = triangle[i][j];
			}
		}




		return result;
	}
}
