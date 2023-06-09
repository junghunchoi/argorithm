package Programmers.problems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Expressn {

    public static void main(String[] args) {



        System.out.println(solutuion(5,12));

    }

    public static int solutuion(int N, int number) {

        List<Set<Integer>> countList = new ArrayList<>();



        for (int i = 0; i < 9; i++) {
            countList.add(new HashSet<>());
        } // 모든 리스트에 hashset을 추가한다.

        countList.get(1).add(N); // 특정숫자를 한개 쓴것은 한개이다.

        for (int i = 2; i < 9; i++) {
            Set<Integer> countSet = countList.get(i);

            for (int j = 1; j <=i ; j++) {

                Set<Integer> preSet = countList.get(j);
                Set<Integer> postSet = countList.get(i-j);

                for (int preNum : preSet) {
                    for (int postNum : postSet) {
                        countSet.add(preNum + postNum);
                        countSet.add(preNum - postNum);
                        countSet.add(preNum * postNum);

                        if (preNum != 0 && postNum != 0) {
                            countSet.add(preNum / postNum);
                        }

                    }
                }
                countSet.add(Integer.parseInt(String.valueOf(N).repeat(i)));

            }

            for (Set<Integer> sub : countList) {
                if (sub.contains(number)) {
                    return countList.indexOf(sub);
                }
            }

            System.out.println(countList.toString());

        }


        return -1;

    }

}

