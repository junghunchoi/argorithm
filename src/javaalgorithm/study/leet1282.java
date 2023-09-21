package javaalgorithm.study;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class leet1282 {

	public static void main(String[] args) {
		leet1282 con = new leet1282();

		System.out.println(con.groupThePeople(new int[]{3,3,3,3,3,1,3}).toString()); // [5], [0,1,2], [3,4,6]
	}

	public List<List<Integer>> groupThePeople(int[] groupSizes) {
		List<List<Integer>> ans = new ArrayList<>();

		Map<Integer, List<Integer>> map = new HashMap<>();

		for (int i = 0; i < groupSizes.length; i++) {
			int value = groupSizes[i];

			if (!map.containsKey(value)) {
				map.put(value, new ArrayList<>());
				map.get(value).add(i);
			} else {
				map.get(value).add(i);
			}
			if (map.get(value).size() == value) {
//				System.out.println(" i: " + i + " value : " + value);
				ans.add(map.get(value));
				map.remove(value);
			}

			// 사이즈가 더 크면 뱉은 후 다시 넣는다.
		}
		
		
		return ans;
	}
}
