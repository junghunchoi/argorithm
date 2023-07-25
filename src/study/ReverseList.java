package study;

import java.util.LinkedList;
import java.util.List;

public class ReverseList {

	public static void main(String[] args) {
		System.out.println(solution(new int[]{1, 2, 3, 4, 5}, 2, 4).toString());
	}

	public static List<Integer> solution(int[] arr,int left , int right) {

		List<Integer> linkedList = new LinkedList<>();

		int leftindex = left-1;
		int rightindex = right-1;

		for (int i = 0; i < arr.length; i++) {
			linkedList.add(arr[i]);
		}

		while (leftindex < rightindex) {
			int temp = 0;

			temp = linkedList.get(rightindex);

			linkedList.set(rightindex, linkedList.get(leftindex));

			linkedList.set(leftindex, temp);

			leftindex++;
			rightindex--;

		}



		return linkedList; //

	}
}
