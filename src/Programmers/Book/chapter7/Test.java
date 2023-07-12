package Programmers.Book.chapter7;

public class Test {

	public static void main(String[] args) {
		문자열_내_마음대로_정렬하기 cons1 = new 문자열_내_마음대로_정렬하기();
		가장_큰_수 cons2 = new 가장_큰_수();
		K번째수 cons3 = new K번째수();

		String[] arr = {"sun", "bed", "car"};
		int[] arr1 = {6, 10, 2,4,6,9};
//		Arrays.stream(cons1.solution(arr,1)).forEach(System.out::println);
		System.out.println(cons2.solution(arr1));

	}



}
