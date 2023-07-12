package Programmers.Book.chapter6;

import java.util.Arrays;

public class Test {

    public static void main(String[] args) {
//        불량_사용자 cons = new 불량_사용자();
        소수찾기 cons2 = new 소수찾기();
        카펫 cons3 = new 카펫();
        모의고사 cons4 = new 모의고사();



        String[] user_id = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
        String[] banned_id = {"fr*d*", "abc1**"};
        String var1 = "127";
        int[] arg = {1, 2, 3, 4, 5};

        Arrays.stream(cons4.solution1(arg)).forEach(System.out::println);

//        cons.solution(user_id, banned_id);
//        cons2.solution(var1);


    }

}
