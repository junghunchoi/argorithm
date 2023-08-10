package Programmers.Book.chapter12;

//https://school.programmers.co.kr/learn/courses/30/lessons/67256
public class 키패드_누르기 {
	/*
		1) 3034.08.11 키패드의 위치를 x,y 축으로 생각해서 풀던가.
	 */

	public static void main(String[] args) {

		키패드_누르기 con = new 키패드_누르기();

		System.out.println(con.solution(new int[]{1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5},"left"));// "LRLLLRLLRRL"
	}

	public String solution(int[] numbers, String hand) {

		String[] result = new String[numbers.length];
		boolean isRightHand = false;
		int rightPosition = 0;
		int leftPosition = 0;


		if(hand.equals("right")) isRightHand = true;

		for (int i = 0; i < numbers.length; i++) {
			if(numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7){
				result[i] = "L";

			}

			else if (numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9) {
				result[i] = "R";
			} else {
				if()
			}

		}

	}

}
