package Programmers.Book.chapter6;


import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

//https://school.programmers.co.kr/learn/courses/30/lessons/67257
public class 수식의_최대화 {

//    시간 복잡도가 바뀐다.
//    rraylist를 사용할 경우 o(n)이 걸리지
//    t를 사용할 경우 o(1)이 사용된다.

	private static final String[][] precedences = {"+-*".split(""), "+*-".split(""),
			"-+*".split(""), "-*+".split(""), "*+-".split(""), "*-+".split(""),};

	private long calculate(long lhs, long rhs, String op) {
		switch (op) {
			case "+":
				return lhs + rhs;
			case "-":
				return lhs - rhs;
			case "*":
				return lhs * rhs;
			default:
				throw new IllegalArgumentException("Invalid operator: " + op);
		}
	}

	private long calculate(List<String> tokens, String[] precedence) {
		for (String op : precedence) {
			for (int i = 0; i < tokens.size(); i++) {
				System.out.println("op" + op + " tokens : " + tokens.toString());
				if (tokens.get(i).equals(op)) {
					long lhs = Long.parseLong(tokens.get(i - 1));
					long rhs = Long.parseLong(tokens.get(i + 1));
					long result = calculate(lhs, rhs, op);
					tokens.remove(i - 1); // 연산자 앞 숫자
					tokens.remove(i - 1); // 연산자
					tokens.remove(i - 1); // 연산자 뒤 숫자
					tokens.add(i - 1, String.valueOf(result)); // 계산한 숫자 추가
					i -= 2; // 3개를 뺏지만 하나를 더했으니 2개 뺸다.
				}
			}
		}
		return Long.parseLong(tokens.get(0));
	}

	public long solution(String expression) {
		StringTokenizer tokenizer = new StringTokenizer(expression, "+-*", true);
		List<String> tokens = new ArrayList<>();
		while (tokenizer.hasMoreTokens()) {
			tokens.add(tokenizer.nextToken());
		}

		long max = 0;
		for (String[] precedence : precedences) {
			long value = Math.abs(calculate(new ArrayList<>(tokens), precedence));
			if (value > max) {
				max = value;
			}
		}
		return max;
	}
}

