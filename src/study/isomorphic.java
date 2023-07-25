package study;


import java.util.HashMap;
import java.util.Map;

public class isomorphic {


	public boolean solution(String s, String t) {

		// 같은 순서로 같아야된다.

		Map<Character, Character> map = new HashMap<>();


		for (int i = 0; i < s.length(); i++) {
			char sindex = s.charAt(i);
			char tindex = t.charAt(i);

			// 존재할 때
			if (map.containsKey(sindex)) {
				// 키 - 밸류 안맞으면 리턴
				if (tindex != map.get(sindex)) return false;
			} else if (map.containsValue(tindex)) { // 존재 안하는데 같은 값이 이미 맵핑되어있다면 리턴
				return false;
			} else {
				map.put(sindex, tindex);
			}
		}
		return true;

	}
}
