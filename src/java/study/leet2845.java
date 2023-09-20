//package study;
//
//
//import java.util.List;
//
////https://leetcode.com/problems/count-of-interesting-subarrays/description/
//public class leet2845 {
//
//	public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
//
//		/*
//		long res = 0;
//        int acc = 0;
//        HashMap<Integer, Integer> map = new HashMap<>(Map.of(0, 1));
//        for (int a : A) {
//            acc = (acc + (a % mod == k ? 1 : 0)) % mod;
//            res += map.getOrDefault((acc - k + mod) % mod, 0);
//            map.put(acc, map.getOrDefault(acc, 0) + 1);
//        }
//        return res;
//		 */
//
//		/*
//		   int n = v.length;
//        for (int i = 0; i < n; i++) {
//            if (v[i] % mod == k)
//                v[i] = 1;
//            else
//                v[i] = 0;
//        }
//
//        Map<Integer, Long> m = new HashMap<>();
//        int p = 0;
//        long ans = 0;
//
//        for (int i = 0; i < n; i++) {
//            p = (p + v[i]) % mod;
//            if (p == k)
//                ans++;
//
//            int rem = p - k;
//            if (rem < 0)
//                rem += mod;
//
//            ans += m.getOrDefault(rem, 0L);
//            m.put(p, m.getOrDefault(p, 0L) + 1);
//        }
//
//        return ans;
//		 */
//
//	}
//}
