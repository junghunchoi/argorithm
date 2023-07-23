package study;

//https://www.acmicpc.net/problem/20922
public class 겹치는건싫어 {

	public static void main(String[] args) {
		System.out.println();
	}

	public static int solution(int N, int K, int arr[]) {

		int answer = 0;
		int start = 0;
		int end = 0;
		int[] count = new int[100001];


		while (end < arr.length) {


			while (end < arr.length && count[arr[end]] + 1 <= K) {
				count[arr[end]]++;
				end++;
			}

			int len = end - start;
			answer = Math.max(answer, len);
			count[arr[start]]--;
			start++;
		}

		return answer;
	}
}
