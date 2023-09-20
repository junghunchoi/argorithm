package java.Programmers.Book.chapter4;

public class 삼진법뒤집기 {

	public static void main(String[] args) {

		int n = 45;

		String str = Integer.toString(n, 3);//tostring에 인자 넣으면 n진법으로 문자열 반환.

		String reversed = new StringBuilder(str).reverse().toString();

		System.out.println(Integer.valueOf(reversed));

	}
}
