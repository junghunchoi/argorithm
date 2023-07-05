package Programmers.Book.chapter4;

public class 시저_암호 {

    public static void main(String[] args) {

        System.out.println(solution("AB",2));
    }

    public static String solution(String s, int n) {

        StringBuilder builder = new StringBuilder();

        for (char c : s.toCharArray()) {
            builder.append(push(c, n));
        }

        return builder.toString();
    }

    private static char push(char c, int n) {

        if (!Character.isAlphabetic(c)) return c;

        int offset = Character.isUpperCase(c) ? 'A' : 'a';

        int position = c - offset; // A랑 주어진 arg의 차이를 셋팅한다.

        position = (position+n) % ('Z' - 'A' + 1); // 연산은 0부터 시작하는데 'a'는 1이므로 하나 더한다.

        return (char)(offset+position);
    }



}
