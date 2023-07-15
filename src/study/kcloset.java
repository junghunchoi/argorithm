package study;

import java.util.*;

public class kcloset {
	public static void main(String[] args) {
		kcloset cons = new kcloset();
		int[] arr = {1, 2, 3, 4, 5};

		Arrays.stream(cons.solution(arr, 4, 3)).forEach(System.out::println);

	}

	public int[] solution(int[] arr, int k, int x) {
		int[] answer = new int[k];

		HashMap<Integer, Integer> map = new HashMap<>();

		for (int i : arr) {
			map.put(i, Math.abs(i - x));
		}

		List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(map.entrySet());

		entryList.sort(Map.Entry.comparingByValue());
		List<Integer> sortedKeys = new ArrayList<>();
		for (Map.Entry<Integer, Integer> entry : entryList) {
			sortedKeys.add(entry.getKey());
		}
		for (int i = 0; i < k-1; i++) {
			answer[i] = sortedKeys.get(i);
		}


		return answer;
	}
}



/* public List<Integer> findClosestElements(int[] arr, int k, int x) {
        // index 와 x의 차이값을 저장
        final HashMap<Integer, Integer> closer = new HashMap<>();
        for(int i=0; i<arr.length; i++) {
            closer.put(i, Math.abs(arr[i] - x));
        }

        // 차이값을 기준으로 오름차순 정렬
        ArrayList<Integer> keySet = new ArrayList<>(closer.keySet());
        Collections.sort(keySet, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return closer.get(o1).compareTo(closer.get(o2));
            }
        });

        // k개만큼 뽑은 후 오름차순 정렬
        ArrayList<Integer> result = new ArrayList<>();
        for(int i=0; i<k; i++) {
            result.add(arr[keySet.get(i)]);
        }
        Collections.sort(result);

        return result;
    }*/