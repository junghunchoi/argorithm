package study;

public class 타노스 {

	public static void main(String[] args) {
		System.out.println(solution("00110000")); // 0001
	}

	public static String solution(String s) {

		String ones = s.replace("0", "");
		String zeros = s.replace("1", "");


		String combine = zeros.substring(zeros.length()/2) + ones.substring(ones.length()/2);

		for (int i = 0; i < combine.length(); i++) {
			if (i % 2 == 0) {
				if (combine.charAt(i) == '1') return "";
			} else {
				if (combine.charAt(i) == '0') return "";
			}
		}

		return combine;
	}
}
