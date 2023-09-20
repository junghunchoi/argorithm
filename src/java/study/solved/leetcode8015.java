package java.study.solved;

public class leetcode8015 {

	public int solution(String rl) {
		/*
		8월4주차 1
		 */
		int underbar = 0;
		int countR = 0;
		int countL = 0;

		for (String s : rl.split("")) {
			if (s.equals("_")) underbar++;
			if (s.equals("R")) countR++;
			if (s.equals("L")) countL++;
		}

		return underbar + Math.abs(countR - countL);
	}
}