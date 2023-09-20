package java.Programmers.Book.chapter4;

//https://programmers.co.kr/learn/courses/30/lessons/12930
public class 이상한_문자_만들기 {

	  /* 복습
        1) 2023.07.15
        2) 2023.08.08
     */


	public static void main(String[] args) {

		String str = "try hello world";

//		System.out.println(solution(str));

//		System.out.println(testSolution(str));
	}

	public static String solution(String arg) {

		StringBuilder builder = new StringBuilder();
		Boolean isUpper = true;

		for (char c : arg.toCharArray()) {
			if (!Character.isAlphabetic(c)) {
				builder.append(c);
				isUpper = true;
			} else {
				if (isUpper) {
					builder.append(Character.toUpperCase(c));
					isUpper = false;
				} else {
					builder.append(c);
					isUpper = true;
				}

			}
		}


		return builder.toString();
	}

}
