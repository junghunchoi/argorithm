package Programmers.Book.chapter8;

public class Test {
	public static void main(String[] args) {
		순위_검색 cons1 = new 순위_검색();
		입국검사 cons2 = new 입국검사();

		String[] info = {"java backend junior pizza 150", "python frontend senior chicken 210", "python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80", "python backend senior chicken 50"};
		String[] query = {"java and backend and junior and pizza 100", "python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250", "- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150"};

		//cons2.solution(6, new int[]{7, 10});

	}
}
