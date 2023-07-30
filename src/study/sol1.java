package study;

import java.util.HashSet;
import java.util.Set;

public class sol1 {

	public int countCompleteSubarrays(int[] nums) {

		int answer = 0;
		Set<Integer> set = new HashSet<>();
		Set<Integer> Numcount = new HashSet<>();


		for (int i : nums) {
			Numcount.add(i);
		}

		int count = Numcount.size();

		for (int i = 0; i < nums.length; i++) {
			set.clear();

			for (int j = i; j < nums.length; j++) {
				set.add(nums[j]);

				if(set.size()>=count) answer++;
			}


		}

		return answer;
	}


}
