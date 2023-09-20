package java.study;

//https://leetcode.com/problems/minimum-operations-to-make-a-special-number/description/
public class leet2844 {

	public static void main(String[] args) {
		leet2844 con = new leet2844();

		System.out.println(con.minimumOperations("2240540")); // 47이 빠져야됨 . ans = 2
	}

	public int minimumOperations(String num) {
		// 특정숫자가 주어졌을 때 어떤 숫자를 뺴서 25로 나눠지는 제일 적은 수행횟수를 반환.

		// 25로 나눠 떨여질려면 마지막 2자리 숫자만 확인하면된다.

		int ans = num.length(), n = num.length();
		for (int i = n - 1; i >= 0; i--) {
			for (int j = i - 1; j >= 0; j--) {
				int t = (num.charAt(i) - '0') + (num.charAt(j) - '0') * 10;
				if (t % 25 == 0) {
					ans = Math.min(ans, n - j - 2);
					System.out.println(n + "  " + j + "  " + ans);
				}
			}
			if (num.charAt(i) == '0') ans = Math.min(ans, n - 1); // To take the only '0' case
		}
		return ans;

	}
}
