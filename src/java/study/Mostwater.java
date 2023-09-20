package java.study;

//https://leetcode.com/problems/container-with-most-water/
public class Mostwater {

	public static void main(String[] args) {

		int[] height = {1,1};

		System.out.println(solution(height));

	}

	public static int solution(int[] height) {
		//제일 끝쪽 부터해서 너비를 체크해야한다.

		int start = 0;
		int end = height.length - 1;

		int sum = 0;

		while (start < end) {

			int check = (end - start ) * Math.min(height[start], height[end]);

			sum = Math.max(check, sum);

			if (height[start] < height[end]) {
				start++;
			}
				end--;
		}

		return sum;
	}
}
