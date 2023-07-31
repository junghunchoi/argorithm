package study;

import java.util.Arrays;

//https://www.acmicpc.net/problem/10174
public class 팰린드롬 {

	public static void main(String[] args) {

		String[] strings = new String[]{"6", "Nat tan", "Palindrome", "123454321", "Dogs and Cats", "**()()**","1 221"};

		Arrays.stream(solution(strings)).forEach(System.out::println);


	}

	public static String[] solution(String[] strings) {

		String[] answer = new String[strings.length];

		for (int i = 0; i < strings.length-1; i++) {
			String index = strings[i].toUpperCase();
			int start = 0;
			int end = index.length() - 1;

			while (start <= end) {
//				System.out.println(index.charAt(start) + "  " + index.charAt(end));
				if (index.charAt(start) != index.charAt(end)) {
					answer[i] = "false";
					break;
				}
				start++;
				end--;
			}

			answer[i] = "true";

		}

		return answer;
	}


}
