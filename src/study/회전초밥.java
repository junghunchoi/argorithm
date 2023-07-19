package study;

public class 회전초밥 {

	public static void main(String[] args) {
		int[] sushi = new int[]
	}


	public int solution(int n, int d, int k, int c, int[] sushi) {

		int count  = 0;
		int max  = 0;
		int[] eat = new int[d + 1];

		for (int i = 0; i < k; i++) {
			int a = sushi[i];

			if (sushi[a] == 0) {
				count++;
			}
			sushi[a]++;
		}
		max = count;

		for (int i = 0; i < n-1; i++) {
			
		}

		return 0;
	}
}
