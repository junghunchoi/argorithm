package Programmers.Book.charpter8;

import java.util.Arrays;

//https://school.programmers.co.kr/learn/courses/30/lessons/43238
public class 입국검사 {

	public long solution(int n, int[] times) { // 대기자 , 심사원별 걸리는 시간.

		long answer = 0;
		Arrays.sort(times);

		long left = 0;
		long right = (long) n * times[times.length - 1]; // 가장 오래걸리는 심사위원이 모든 사람을 보는 경우

		while (left <= right) {
			long mid = (right + left) / 2;
			long sum = 0; // 몇명의 사람을 심사했는지


			for (int i = 0; i < times.length; i++) {
				sum += mid / times[i]; // 왜 나눠
			}

			System.out.println("left : " + left + " right : " + right + " sum : " + sum);

			if (sum < n) { // 해야할 인원보다 심사처리 못함 -> 시간 더 필요
				left = mid + 1;
			} else { // 해야할 인원보다 심사처리 많이함 -> 시간을 줄여서 더 최고 경우의 시간을 만든다.
				right = mid - 1;
				answer = mid;
			}
		}
		return answer;
		}

	}



