package Programmers.Book.chapter12;

public class 키패드_누르기 {

	public static void main(String[] args) {

	}

	public String solution(int[] numbers, String hand) {

		String[] result = new String[numbers.length];

		for (int i = 0; i < numbers.length; i++) {
			if(numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7) result[i] = "L";
			else if (numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9) {
				result[i] = "R";
			} else {

			}

		}

	}

}
