package Programmers.Book.chapter7;

import java.util.Arrays;

public class K번째수 {

	/*
	2023.07.12
	*/

	public int[] solution(int[] array, int[][] command) {
		int[] answer = new int[command.length];

		for (int i = 0; i < command.length; i++) {
			int startIndex = command[i][0];
			int endIndex = command[i][1];
			int index = command[i][2];

			int[] sub = Arrays.copyOfRange(array, startIndex, endIndex);
			Arrays.sort(sub);

			answer[i] = sub[index];
		}

		return answer;
	}

	}
