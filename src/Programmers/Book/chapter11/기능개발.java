package Programmers.Book.chapter11;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//https://school.programmers.co.kr/learn/courses/30/lessons/42586
public class 기능개발 {

	public static void main(String[] args) {

		Arrays.stream(solution(new int[]{95, 90, 99, 99, 80, 99}, new int[]{1, 1, 1, 1, 1, 1})).forEach(System.out::println);//1,3,2

	}


	public static int[] solution(int[] progress, int[] speeds) {
		
		// 나눴을 때 나머지가 5 10 1 1 20
		//큐를 왜쓰는거야?
		
		Queue<Integer> queue = new LinkedList<>();
		ArrayList<Integer> arrayList = new ArrayList<>();


		for (int i = 0; i < progress.length; i++) {
			double remain = (100 - progress[i]) / (double) speeds[i];
			int day =(int) Math.ceil(remain);


			if (!queue.isEmpty() && queue.peek() < day) {// 값이 존재하는데
				arrayList.add(queue.size());
				queue.clear();
			}
			queue.offer(day);


		}
		arrayList.add(queue.size());
		return arrayList.stream().mapToInt(Integer::intValue).toArray();

	}
}
