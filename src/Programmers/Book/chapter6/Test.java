package Programmers.Book.chapter6;

public class Test {

    public static void main(String[] args) {
        불량_사용자 cons = new 불량_사용자();
        소수찾기 cons2 = new 소수찾기();

        String[] user_id = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
        String[] banned_id = {"fr*d*", "abc1**"};

        String var1 = "127";

//        cons.solution(user_id, banned_id);
        cons2.solution(var1);

    }

}
