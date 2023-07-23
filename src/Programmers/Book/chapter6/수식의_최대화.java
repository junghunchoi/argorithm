package Programmers.Book.chapter6;


import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

//https://school.programmers.co.kr/learn/courses/30/lessons/67257
public class 수식의_최대화 {

	/* 1) 2023.07.23 40분


	 */

	private static final String[][] precedences = {"+-*".split(""), "+*-".split(""),
			"-+*".split(""), "-*+".split(""), "*+-".split(""), "*-+".split(""),};

	public static void main(String[] args) {
		수식의_최대화 con = new 수식의_최대화();

		int num = -20000;

		System.out.println(con.solution("100-200*300-500+20"));

	}


	public int solution(String str) {
		int answer = 0;

		StringTokenizer token = new StringTokenizer(str, "+-*",true);
		List<String> list = new LinkedList<>();

		while (token.hasMoreTokens()) {
			list.add(token.nextToken());
		}

		for (int i = 0; i < precedences.length-1; i++) {
			// 연산자 순서대로 계산하고 계산한 값을 넣어야함
			// 순서대로?
			answer = Math.max(answer, calculate(list, precedences[i]));

		}

		// 우선 순위대로
		return answer;
	}

	private int calculate(int num1, int num2, String delim) {

		switch (delim) {
			case "+" : return num1+num2;
			case "-" : return num1-num2;
			case "*" : return num1*num2;
			default:throw  new IllegalArgumentException("이상한 연산자");
		}
	}

	private int calculate(List<String> list, String[] procedure) {


		// 연산자 배열을 순회하긴 해야해.
		for (String operator : procedure) {
//			int index = list.indexOf(s);

			for (int i = 0; i < list.size()-1; i++) {
				if (list.get(i)
						.equals(operator)) {
					int num1 = Integer.parseInt(list.get(i - 1));
					int num2 = Integer.parseInt(list.get(i + 1));
					String calcNum = String.valueOf(calculate(num1, num2, list.get(i)));

					System.out.println(" i : " + i + " list : " + list.toString()) ;
					list.remove(i - 1);
					list.remove(i-1 );
					list.remove(i -1);
					list.add(i - 1, calcNum);
					i -= 2;
				}
				
			}


		}

		return Integer.parseInt(list.get(0));
	}
}

