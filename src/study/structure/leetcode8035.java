package study.structure;

import java.util.List;
import java.util.PriorityQueue;

//https://leetcode.com/problems/minimum-operations-to-form-subsequence-with-target-sum
public class leetcode8035 {
	/*
		1) 8월4주차

	풀이법 -> 제일 큰 값을 가지고 장난을 쳐야할 땐 pq를 사용하고 연산은 사고력이 필요한데 많이 풀어보고 학습해보자.
		 */

	public static void main(String[] args) {
		leetcode8035 con = new leetcode8035();

		System.out.println(con.minOperations(List.of(1,2,8), 9));
	}

	public int minOperations(List<Integer> nums, int target) {

		PriorityQueue<Integer> pq = new PriorityQueue<>((a, b)->b-a);
		long sum = 0;
		for(int num : nums){
			sum += num;
			pq.add(num);
		}

		int opt = 0;

		while(target>0){
			int front = pq.poll();
			sum -= front;

			if(front <= target) {
				target -= front;
			}
			else if(front > target && sum < target) { // 제일 큰 머리빼고도 타겟을 맞출 수 있는 경우
				opt++;
				sum += front;
				pq.offer(front/2);
				pq.offer(front/2);
			}
//			System.out.println(pq.toString()+ "   " + target + "   " + sum);
			if(pq.isEmpty() && target != 0) { // 타겟은 남아있는데 남아있는 머리로 연산을 할 수 있는 경우
				if(front > target && front != 1) { // 머리가 타겟보다는 크고 타겟이 1이 아닌 경우
					opt++;
					sum += front;
					pq.offer(front/2);
					pq.offer(front/2);
				}
				else { // 연산할 수 없으므로 -1 리턴한다.
					return -1;
				}
			}
		}
		return opt;
	}
}
