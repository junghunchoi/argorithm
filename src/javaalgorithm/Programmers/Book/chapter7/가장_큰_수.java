package javaalgorithm.Programmers.Book.chapter7;


import java.util.Arrays;

//https://school.programmers.co.kr/learn/courses/30/lessons/42746
public class 가장_큰_수 {
	/*
	2023.07.11
	2023.07.12
	*/

	public static void main(String[] args) {

		가장_큰_수 cons = new 가장_큰_수();
		System.out.println(cons.solution(new int[]{6,10,2}));
	}

	public String solution(int[] arr) {

		String[] intToString = new String[arr.length];

		for (int i = 0; i < arr.length; i++) {
			intToString[i] = String.valueOf(arr[i]);
		}

		Arrays.sort(intToString,(o1,o2)->(o2+o1).compareTo(o1+o2));



		return Arrays.stream(intToString)
				.reduce("", (s1, s2) -> s1 + s2);
	}





}
