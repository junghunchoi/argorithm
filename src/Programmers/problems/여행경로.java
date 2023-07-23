package Programmers.problems;

import java.util.ArrayList;

//https://school.programmers.co.kr/learn/courses/30/lessons/43164
// Category : DFS
// 일단 여러문제 풀어보고 해결방법을 암기한 후 이해하는게 빠를 것 같아
public class 여행경로 {
    static ArrayList<String> list = new ArrayList<>();
    static boolean[] useTickets ;


    public static void main(String[] args) {

        String[][] tickets = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};

        useTickets = new boolean[tickets.length];

        dfs(0,"ICN","ICN",tickets);


        //    ICNJFKHNDIAD
        for (String path : list) {
            System.out.println(path);
        }

    }

    static void dfs(int depth, String now, String path, String[][] tickets) {
        System.out.println("dfs("+depth+","+now+","+path+",tickets)");
        if (depth == tickets.length) {
            list.add(path);
            return;
        }// 티켓길이가 끝까지 갔을 경우 최종 경로를 붙이고 리턴

        for (int i = 0; i < tickets.length; i++) {
//            System.out.println("i:" + i + "[0]" + tickets[i][0] + "[1]" + tickets[i][1] + " depth: " + depth+ " path : " + path);

            if (!useTickets[i] && now.equals(tickets[i][0])) { // 티켓은 사용하지 않았고
                useTickets[i] = true;
                dfs(depth+1,tickets[i][1],path+""+tickets[i][1],tickets);

                useTickets[i] = false;
            }

        }
    }





}
