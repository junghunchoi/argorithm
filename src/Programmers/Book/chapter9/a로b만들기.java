package Programmers.Book.chapter9;

public class a로b만들기 {

	public static void main(String[] args) {
		a로b만들기 cons = new a로b만들기();
		System.out.println(cons.solution("apple","elppa"));
	}

	private int solution(String a, String b) {
		StringBuilder stringBuilder =  new StringBuilder(a);


		boolean reverse = String.valueOf(stringBuilder.reverse())
				.equals(b);

		return reverse ? 1 : 0;

	}
}
