package Programmers.Book.chapter12;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;

//https://programmers.co.kr/learn/courses/30/lessons/42862
public class 체육복 {
	public static void main(String[] args) {

		체육복 con = new 체육복();

		System.out.println(con.solution(5,new int[]{2,4}, new int[]{1,3,5}));//5


	}

	public int solution(int n, int[] lost, int[] reserve) {
		Arrays.sort(lost);
		Arrays.sort(reserve);

		Set<Integer> set = Arrays.stream(lost).boxed().collect(Collectors.toSet()); // 여벌이 있는 사람의 리스트
		set.retainAll(Arrays.stream(reserve).boxed().collect(Collectors.toSet())); // 내부인자에서 기존 리스트의 중첩된 항목을 제거한다.

		Queue<Integer> q = new LinkedList<>();

		for (int i : lost) q.add(i);

		int get = 0;

		for (int i : reserve) {
			// 리스트에 없는 경우 넘어가야함.
			if(set.contains(i)) continue;

			//빌려줘서 잃어버린 사람을 삭제해야한다.
			//큐가 비어있지 않다, 잃어버런 숫자가 줄 수 있는 사람의 -1보다 작아야한다? ,
			while(!q.isEmpty() && (q.peek() < i-1 || set.contains(q.peek()))) q.poll();

			if(q.isEmpty()) break;

			if (q.peek() <= i + 1) {
				q.poll();
				get++;
			}

		}


		return n - lost.length + set.size() + get;

		/*
		     HashSet<Integer> reserveSet = new HashSet<>();
        HashSet<Integer> lostSet = new HashSet<>();

        for (int i : reserve)
            reserveSet.add(i);
        for (int i : lost) {
            // 중복 확인
            if (reserveSet.contains(i)) {
                reserveSet.remove(i);
            } else {
                lostSet.add(i);
            }
        }


        // 2. 여분을 기준으로 앞뒤로 확인하여 체육복을 빌려준다.
        for (int i : reserveSet) {
            if (lostSet.contains(i - 1)) {
                lostSet.remove(i - 1);
            } else if (lostSet.contains(i + 1)) {
                lostSet.remove(i + 1);
            }
        }

        // 3. 전체 학생 수에서 lostSet에 남은 학생 수를 빼주면 정답이다.
        return n - lostSet.size();
		 */
	}
}
