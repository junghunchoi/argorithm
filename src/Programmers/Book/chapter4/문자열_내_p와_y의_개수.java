package Programmers.Book.chapter4;


//https://programmers.co.kr/learn/courses/30/lessons/12916
//복습x
//복습x
//복습x
//복습x
public class 문자열_내_p와_y의_개수 {

	public boolean solution(String s) {


		String arr[] = s.split("");

		int countP = 0;
		int countY = 0;

		for (String index : arr) {
			if (index.equals("p")) countP++;
			if (index.equals("y")) countY++;
		}

		return countP == countY;
	}
}
