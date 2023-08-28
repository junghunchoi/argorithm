package Programmers.Book.chapter12;

//https://school.programmers.co.kr/learn/courses/30/lessons/43163
public class 단어_변환 {

	int answer = 0;

	public int solution(String begin, String target, String[] words) {
		boolean[] visited = new boolean[words.length];

		dfs(begin, target, words, 0,visited);
		return answer;
	}

	public void dfs(String begin, String target, String[] words, int cnt,boolean[] visited ) {
		if (begin.equals(target)) {
			answer = cnt;
			return;
		}

		for (int i = 0; i < words.length; i++) {
			if(visited[i]) continue;

			int k = 0;
			for (int j = 0; j < begin.length(); j++) {
				if (begin.charAt(j) == words[i].charAt(j)) k++;

			}
			if (k == begin.length() - 1) {
				visited[i] = true;
				dfs(words[i], target, words, cnt + 1, visited);
				visited[i] = false;
			}
		}



	}
}
