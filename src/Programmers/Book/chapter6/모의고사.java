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

		int[] arg = {1, 2, 3, 4, 5};

	Arrays.stream(addsolution(arg)).forEach(System.out::println);

	}


	private static int getPicked(int person, int problem) {
		int[] rule = supo[person]; // 각 수포자의 값을 배열에 셋팅
		int index = problem % supo.length; // 찍고자하는 패턴을 순회하도록 인덱스값 셋팅

		return rule[index]; // 인덱스별 찍은 답을 리턴
	}

	public static int[] solution(int[] answers) {

		int[] corrects = new int[3];
		int max = 0;

		for (int problem = 0; problem < answers.length; problem++) {
			int answer = answers[problem];

			for (int person = 0; person < 3; person++) {
				// 바람별로 돌고 인덱스별로
				int picked = getPicked(person, problem);

				if (answer == picked) { // 해당인덱스의 값과 정답이 일치하면
					if (++corrects[person] > max) {
						max = corrects[person];
					}
				}
			}
		}

		final int maxCorrects = max;

		return IntStream.range(0, 3)
				.filter(i -> corrects[i] == maxCorrects)
				.map(i -> i + 1)
				.toArray();
	}


	////////////////
	public static int[] addsolution(int[] answer) {
	// 누가 가장 많이 맞췃는가
		int[] corrects = new int[3];

		for (int i = 0; i < supo.length-1; i++) {
			System.out.println(i);
			for (int j = 0; j < supo[i].length-1; j++) {
				if(answer[i] == supo[i][j% answer.length]) corrects[i]++;
			}
		}

		int max = 0;

		for (int checkMax : corrects) {
			max = Math.max(checkMax, max);
		}

		int finalMax = max;

		return Arrays.stream(corrects)
				.filter(s -> corrects[s] == finalMax)
				.map(s->s+1)
				.toArray();

	}


}
