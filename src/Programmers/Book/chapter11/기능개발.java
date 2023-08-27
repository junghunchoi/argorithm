package Programmers.Book.chapter11;


import java.util.*;

//https://school.programmers.co.kr/learn/courses/30/lessons/42586
public class 기능개발 {

	/*
	1) 2023.08.24
	 */

	public static void main(String[] args) {

		// 앞의 기능이 먼저 구현이 되면 빼기
		Arrays.stream(solution(new int[]{95, 90, 99, 99, 80, 99}, new int[]{1, 1, 1, 1, 1, 1})) // 5 10 1 1 20 1
				.forEach(System.out::println);//1,3,2

	}


	public static int[] solution(int[] progress, int[] speeds) {
		List<Integer> list = new ArrayList<>();
		Queue<Integer> queue = new LinkedList<>();

		while (queue.isEmpty()) {
			for (int i = 0; i < progress.length; i++) {
				double remain = (100 - progress[i]) / (double) speeds[i];
				int day =(int) Math.ceil(remain);

				if (!queue.isEmpty() && queue.peek() < day) {
					list.add(queue.size());
					queue.clear();
				}

				queue.offer(day);
			}
		}
		list.add(queue.size());
		return list.stream().mapToInt(i->i).toArray();
	}
}
