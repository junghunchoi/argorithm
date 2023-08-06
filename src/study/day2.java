package study;

public class day2 {

	public static void main(String[] args) {
		int[][] grid = {{0, 0, 1}, {0, 0, 0}, {0, 0, 0}};
	}

	private int move(int[] location, int moveX, int moveY, int answer , int[][] grid) {
		int x = location[0];
		int y = location[1];


		if (grid[x + moveX][y + moveY] != 1) {

			move(new int[]{x+moveX, y}, 1,0,answer,grid);
			move(new int[]{x, y+moveY}, 0,1 ,answer,grid);
		}

		return answer;
	}

	public int maximumSafenessFactor(int[][] grid) {
		int answer = 0;

		if (grid[0][0] == 1 || grid[grid.length][grid.length] == 1) {
			return 0;
		}

		move(new int[]{0,0},0,0,answer,grid);

		return answer;

	}
}
