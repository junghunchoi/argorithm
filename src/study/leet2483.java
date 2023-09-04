package study;

//https://leetcode.com/problems/count-symmetric-integers/description/
public class leet2483 {

	public static void main(String[] args) {

		leet2483 con = new leet2483();
		System.out.println(con.countSymmetricIntegers(1, 100));

	}


	public int countSymmetricIntegers(int low, int high) {
		// 2,4,6.. 자리의 숫자에서 절반의 자리수 기준으로 각각의 합이 일치할 떄.
		// 중간 자릿수를 기점으로 양쪽의 총합을 더하기 때문에 개별 인덱스는 신경쓸 필요가 없다.
		int ans = 0;


		return ans;
	}
}






/*
for (int i = low; i <= high; i++) {
			String s = Integer.toString(i);
			int t = 0;
			int n = s.length();

			for (int j = 0; j < n/2; j++) { // 반복한 문자열의 처음부터 절반까지의 자릴수까지
				t += s.charAt(j) - s.charAt(n - j - 1);
			}
			if(n%2 == 0 && t == 0) ans++;
		}
 */
