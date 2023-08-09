package Programmers.Book.chapter11;

import java.util.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/42627
public class 디스크_컨트롤러 {
	/*
	1) 봤지만 못풀었다.
	 */
	public static void main(String[] args) {

		System.out.println(solution1(new int[][]{{0,3},{1,9},{2,6}})); // 9

	}
//
//	public static int solution(int[][] rawJobs) {
//		Job[] jobs = new Job[rawJobs.length];
//		for (int i = 0; i < jobs.length; i++) {
//			jobs[i] = new Job(rawJobs[i][0], rawJobs[i][1]);
//		}
//		// 문제조건에서 먼저 요청이 들어온 작업부터 처리해야하기 때문에 시작시간 순서대로 배열을 정렬한다.
//		Arrays.sort(jobs, Comparator.comparingInt(job -> job.start));
//
//		// 큐를 이용하면 직관적으로 사용할 수 있다.
//		Queue<Job> q = new LinkedList<>(Arrays.asList(jobs));
//
//		//시작할 수 있는 작업 중 가장 걸리는 시간이 짧게 걸리는 작업을 선행한다.
//		PriorityQueue<Job> pq = new PriorityQueue<>(
//				Comparator.comparingInt(job -> job.duration));
//
//		// 작업의 누적합과 현재시간을 나타내는 변수
//		int exec = 0;
//		int time = 0;
//
//
//		//queue에 들어있는 작업은 아직 작업의 요청시간에 도달하지 못한 작업. pq에 들어있는 작업은 요청시간이 지낫지만 시작하지 못한 일
//		while (!q.isEmpty() || !pq.isEmpty()) {
//			// 가장 먼저 작업할 수 있는 작업 추출, 요청시간이 지난 작업을 pq추가한다.
//
//
//			while (!q.isEmpty() && q.peek().start <= time) {
//				pq.add(q.poll());
//			}
//			System.out.println(q.toString());
////			System.out.println("exec : " + exec + " time : " + time);
//			//pq가 비어있다면 시작할 수 있는 작업이 없다. 이때 q의 첫번째 작업까지 대기한다.
//			if (pq.isEmpty()) {
//				time = q.peek().start;
//				continue;
//			}
//			System.out.println(pq.peek().toString());
//			Job job = pq.poll();
//			exec += time + job.duration - job.start;
//			time += job.duration;
//			System.out.println("exec : " + exec + " time : " + time);
//		}
//		// 총 수행시간을 작업갯수로 나눠 평균을 구한다.
//		return exec / jobs.length;
//	}

	public static int solution1(int[][] jobs) {

		int answer = 0;
		int end = 0; // 수행되고난 직후의 시간
		int jobsIdx = 0; // jobs 배열의 인덱스
		int count = 0; // 수행된 요청 갯수

		// 원본 배열 오름차순 정렬 (요청시간 오름차순)
		Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);

		// 처리 시간 오름차순으로 정렬되는 우선순위 큐(Heap)
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);

		// 요청이 모두 수행될 때까지 반복
		while (count < jobs.length) {

			// 하나의 작업이 완료되는 시점(end)까지 들어온 모든 요청을 큐에 넣음
			while (jobsIdx < jobs.length && jobs[jobsIdx][0] <= end) {
				pq.add(jobs[jobsIdx++]);
			}

			// 큐가 비어있다면 작업 완료(end) 이후에 다시 요청이 들어온다는 의미
			// (end를 요청의 가장 처음으로 맞춰줌)
			if (pq.isEmpty()) {
				end = jobs[jobsIdx][0];

				// 작업이 끝나기 전(end 이전) 들어온 요청 중 가장 수행시간이 짧은 요청부터 수행
			} else {

				int[] temp = pq.poll();
				answer += temp[1] + end - temp[0];
				end += temp[1];
				count++;
			}
		}

		return (int) Math.floor(answer / jobs.length);
	}

	public static class Job{
		public final int start;
		public final int duration;

		public Job(int start, int duration) {
			this.start = start;
			this.duration = duration;
		}

		@Override
		public String toString() {
			return "Job{" +
					"start=" + start +
					", duration=" + duration +
					'}';
		}
	}


}
