package study.greedy;

//https://leetcode.com/problems/minimum-replacements-to-sort-the-array/
public class leetcode2366 {

	public static void main(String[] args) {
		leetcode2366 con = new leetcode2366();

		System.out.println(con.minimumReplacement(new int[]{2,10,20,19,2}));
	}

	public long minimumReplacement(int[] nums) {

		/*
		int n = nums.length;
		int last = nums[n - 1];  // Initialize 'last' with the last element
		long ans = 0;  // Initialize the total operations count

		// Traverse the array in reverse order
		for (int i = n - 2; i >= 0; --i) {
			if (nums[i] > last) {  // If the current element needs replacement
				int t = nums[i] / last;  // Calculate how many times the element needs to be divided
				if (nums[i] % last != 0) {
					t++;  // If there's a remainder, increment 't'
				}
				last = nums[i] / t;  // Update 'last' for the next comparison
				ans += t - 1;  // Add (t - 1) to 'ans' for the number of operations
				System.out.println("t : " + t + " last : " + last + " ans : " + ans);
			} else {
				last = nums[i];  // Update 'last' without replacement
			}


		}
		return ans;  // Return the total number of operations


		 */

		long answer = 0;
		int n = nums.length;

		// 제일 마지막 -1 인덱스부터 역으로 순회한다.
		for (int i = n - 2; i >= 0; i--) {
			// 앞에께 더 크면 건너뛴다.
			if (nums[i] <= nums[i + 1]) {
				continue;
			}

			// Count how many elements are made from breaking nums[i].
			long numElements = (long)(nums[i] + nums[i + 1] - 1) / (long)nums[i + 1]; // 앞에꺼

			// It requires numElements - 1 replacement operations.
			answer += numElements - 1;

			// Maximize nums[i] after replacement.
			nums[i] = nums[i] / (int)numElements;

			System.out.println("i : " + i + " numelements : " + numElements + " answer : " + answer + " nums[i] : " + nums[i]);
		}

		return answer;



		/*
		Stack<Integer> stack = new Stack<>();
		long ans = 0;

		for (int i : nums) {
			stack.push(i);
		}

		while (!stack.isEmpty()) {
			int check = stack.pop();

			if (!stack.isEmpty() && stack.peek() > check) {
				int divide = stack.pop();

				if (divide / 2 >= check) {
					stack.push(divide - check);
					stack.push(check);
					ans++;
				} else {
					stack.push(divide/2);
					stack.push(divide/2+divide%2);
					ans++;
				}

			}
			System.out.println("check : " + check + "  " + stack.toString() + " ans : " + ans);
		}

		return ans;

		 */

	}
}
