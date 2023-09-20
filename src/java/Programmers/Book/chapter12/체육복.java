package java.Programmers.Book.chapter12;

import java.util.Arrays;

//https://programmers.co.kr/learn/courses/30/lessons/42862
public class 체육복 {
	public static void main(String[] args) {

		체육복 con = new 체육복();

		System.out.println(con.solution(24,new int[]{12, 13, 16, 17, 19, 20, 21, 22}, new int[]{1, 22, 16, 18, 9, 10}));//19


	}

	public int solution(int n, int[] lost, int[] reserve) {
		int[] haves = new int[n+2]; // 0번째 인덱스와, 마지막 인덱스는 비워두는 용도
		int answer = n;

		for(int l : lost) haves[l]--;
		for(int r : reserve) haves[r]++;

		System.out.println(Arrays.toString(haves));

		for(int i=1; i<=n; i++) {
			if(haves[i] == -1) { // 도둑질 당한 경우
				if(haves[i-1] > 0) { // 전에 사람이 여유 있는 경우
					haves[i]++;  // 받앗고
					haves[i-1]--; // 줫고
				} else if(haves[i+1] > 0) {
					haves[i]++;
					haves[i+1]--;
				} else {
					answer--; // 오도가도 못한 경우....
				}
			}
		}

		return answer;
	}
}
