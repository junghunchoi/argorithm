package study;

public class day1 {

	public static void main(String[] args) {
		System.out.println(solution("poiinter"));
	}

	public static String solution(String s) {
		StringBuilder sb = new StringBuilder();

		char[] chars = s.toCharArray();

		for (char c : chars) {
			if (c == 'i') {
				sb.reverse();
				continue;
			}
			sb.append(c);
		}
		return sb.toString();
	}
}
