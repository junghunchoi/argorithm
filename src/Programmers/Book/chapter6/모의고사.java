package Programmers.Book.chapter6;

import java.util.Arrays;
import java.util.stream.IntStream;

//https://school.programmers.co.kr/learn/courses/30/lessons/42840
public class 모의고사 {

	/*
	1) 2023.07.12
	2) 2023.07.23 14분
	*/

	public static int[][] supo = {{1, 2, 3, 4, 5}, {2, 1, 2, 3, 2, 4, 2, 5},
			{3, 3, 1, 1, 2, 2, 4, 4, 5, 5}};



	public static void main(String[] args) {
		모의고사 con = new 모의고사();

		int[] arg = {1,3,2,4,2};


		System.out.println(Arrays.toString(con.solution(arg)));

		// 많이 맞춘 순서대로 반환. 똑같으면 앞순대로 리턴


	}

	/* 1. 배열에 수포자별로 맞은 정답을 입력한다.
	   2. 수포의 정답과 주어진 정답 리스트를 비교한다. -

	 */


	public  int[] solution(int[] answers) {

		int[] list = new int[supo.length];


		for (int i = 0; i < list.length; i++) {
			list[i] = getAnswer(i, answers);
		}

		int maxValue = 0;

		for (int idx : list) {
			maxValue = Math.max(maxValue, idx);
		}

		final int finmaxValue =maxValue;

		return IntStream.range(0, 3).filter(i -> list[i] == finmaxValue).map(i -> i + 1).toArray();
	}

	private  int getAnswer(int i, int[] answers) {

		int[] list = supo[i];
		int count = 0;

		for (int j = 0; j < list.length; j++) {
			if(list[j] == answers[j%answers.length]) count++;

		}

		return count;
	}


}
