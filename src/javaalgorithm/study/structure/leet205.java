package javaalgorithm.study.structure;


import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/isomorphic-strings/
public class leet205 {

	public static void main(String[] args) {
		leet205 co = new leet205();

		System.out.println(co.solution("bbbaaaba","aaabbbba"));
	}

	public boolean solution(String s, String t) {
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
