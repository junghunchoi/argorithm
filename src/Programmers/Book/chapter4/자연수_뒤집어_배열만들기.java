package Programmers.Book.chapter4;


//https://programmers.co.kr/learn/courses/30/lessons/12932
public class 자연수_뒤집어_배열만들기 {


    public static void main(String[] args) {

        int n = 12345;

        System.out.println(solution(n).toString());

    }

    public static char[] solution(int n) {

        StringBuilder stringBuilder = new StringBuilder(String.valueOf(n));

        char[] arr = new char[String.valueOf(n).length()];

        stringBuilder.reverse();


        for (int i = 0; i < stringBuilder.length(); i++) {
            arr[i] = stringBuilder.charAt(i);
        }

        return arr;
    }

}
