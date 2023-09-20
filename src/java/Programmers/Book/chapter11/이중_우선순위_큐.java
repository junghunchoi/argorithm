package java.Programmers.Book.chapter11;

import java.util.Comparator;
import java.util.PriorityQueue;

//https://programmers.co.kr/learn/courses/30/lessons/42628
public class 이중_우선순위_큐 {
	/*
	1) 2023.08.09
	- 최대, 최소값을 구하기 위해선 서로 다른 우선순위큐를 선언한 후 개별적으로 체크해 정답을 구하면 된다.
	 */

	public static void main(String[] args) {



		solution(new String[]{"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"}); //333,-45

	}

	public static int[] solution(String[] strings) {

		DoublePriorityQueue con = new DoublePriorityQueue();



		for (String s : strings) {
			if (s.charAt(0) == 'I') {

				con.add(Integer.valueOf(s.substring(2)));
			} else {
				if(s.charAt(2)=='-') con.removeMin();
				else con.removeMax();

			}

		}
		System.out.println(con.getMax() + "  "+ con.getMin() );
		return new int[]{con.getMax(),con.getMin()};

	}

	public static class DoublePriorityQueue {

		PriorityQueue<Integer> minQueue = new PriorityQueue<>();
		PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Comparator.reverseOrder());

		private void removeMax() {
			if(maxQueue.isEmpty()) return;
			maxQueue.poll();
		}

		private void removeMin() {
			if(minQueue.isEmpty()) return;
			minQueue.poll();
		}

		private int getMax() {
			return Integer.valueOf(maxQueue.peek());
		}

		private int getMin() {
			return Integer.valueOf(minQueue.peek());
		}

		public void add(int n) {
			maxQueue.add(n);
			minQueue.add(n);
		}

		public DoublePriorityQueue() {

		}
	}


}
