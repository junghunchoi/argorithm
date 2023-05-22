package Programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Stream;

//https://school.programmers.co.kr/learn/courses/30/lessons/43164
// Category : DFS
public class TripCourse {
    static ArrayList<String> list = new ArrayList<>();
    static boolean[] useTickets ;


    public static void main(String[] args) {

        String[][] tickets = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};

        useTickets = new boolean[tickets.length];

        dfs(0,"ICN","ICN",tickets);

//        Collections.sort(list);

        //    ICNJFKHNDIAD
        for (String path : list) {
            System.out.println(path);
        }

    }

    static void dfs(int depth, String now, String path, String[][] tickets) {

        if (depth == tickets.length) {
            list.add(path);
            return;
        }// 티켓길이가 끝까지 갔을 경우 최종 경로를 붙이고 리턴

        for (int i = 0; i < tickets.length; i++) {
            if (!useTickets[i] && now.equals(tickets[i][0])) { // 티켓은 사용하지 않았고
                useTickets[i] = true;
                dfs(depth+1,tickets[i][1],path+""+tickets[i][1],tickets);
                useTickets[i] = false;
            }

        }
    }





}
