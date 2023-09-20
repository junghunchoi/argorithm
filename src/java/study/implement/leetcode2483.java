package java.study.implement;

//https://leetcode.com/problems/minimum-penalty-for-a-shop/
public class leetcode2483 {

	/*
	1) 2023.08.29

	시간복잡도가 xn이 되는건 상관없지만 n^2이상이 되는건 지양하자
	 */

	public static void main(String[] args) {
		leetcode2483 con = new leetcode2483();

		System.out.println(con.bestClosingTime("YYNY"));
	}

	public int bestClosingTime(String customers) {
		int curPenalty = 0;

		for (int i = 0; i < customers.length(); i++) {
			if(customers.charAt(i) == 'Y') curPenalty++;
		}

		int minPenalty = curPenalty;
		int earliestHour = 0;

		for (int i = 0; i < customers.length(); i++) {
			char ch = customers.charAt(i);

			if (ch=='Y') curPenalty--;
			else curPenalty++;

			if (curPenalty < minPenalty) {
				earliestHour = i+1;
				minPenalty = curPenalty;

			}
		}
		return earliestHour;
	}
	/*
	public int bestClosingTime(String customers) {
		char[] custom = customers.toCharArray();
		int answer = Integer.MAX_VALUE;
		int hour = 0;
		for (int i = 0; i <= custom.length; i++) {
			int count = countPenalty(i, custom);
			if (count < answer) {
				answer = count;
				hour = i;
			}
		}
		return hour;
	}

	private int countPenalty(int i , char[] custom) {
		int count = 0;
		for (int j = 0; j <i; j++) {
			if (custom[j] == 'N') count++;
		}


		for (int k = i; k < custom.length; k++) {
			if (custom[k] == 'Y') count++;
		}
		return count;
	}
	 */
}
