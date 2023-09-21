package javaalgorithm.study;

public class javavscpp {

	public static void main(String[] args) {

	}

	public static String solution(String s) {

		boolean isjava = false;
		boolean isError = true;

		String answer = "";

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '_') {
				isjava = false;
				isError = false;
				break;
			}

			if (Character.isUpperCase(s.charAt(i))) {
				isjava = true;
				isError = false;
				break;

			}
		}
		if (isError) return "Error!";

		if (isjava) { // _로 컨버팅해야함.
			for (int i = 0; i < s.length(); i++) {
				// 대문자있는 인덱스에 _ + 소문자로 컨버팅해서 answer에 저장
			}
		} else {
			String[] arr = s.split("_");

			for (int i = 0; i < arr.length; i++) {
				if (i >= 1) {
					answer += Character.toUpperCase(arr[i].indexOf(0)) + arr[i].substring(1);
				} else answer += arr[i];
			}
		}

		return answer;

		}
	}

