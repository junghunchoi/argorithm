package javaalgorithm.BakJoon;

import java.util.Arrays;

public class Back2230 {

    /*
    * N개의 정수로 이루어진 수열 A[1], A[2], …, A[N]이 있다.
    * 이 수열에서 두 수를 골랐을 때(같은 수일 수도 있다),
    * 그 차이가 M 이상이면서 제일 작은 경우를 구하는 프로그램을 작성하시오.
    * */

    public static void main(String[] args) {

        int[] arr = {1, 5, 3};

        System.out.println(method(3, arr));

    }

    public static int method(int gap, int[] arr) {

        int answer = 0;

        int hi = 0;
        int lo = 0;

        Arrays.sort(arr);

        // 배열 정렬한다음에
        while (true) {
            // 주어진 gap보다 차이가 적으면 hi를 높인다.
            // lo 가 length일 떄 끝낸다
            // 차이가 크면 lo를 높인다.

            if(hi == arr.length) break;
            System.out.println(hi + "  " + lo + "  " + (arr[hi]- arr[lo]));
            if(arr[hi] - arr[lo] <= gap) hi++;
            else if (lo == arr.length - 1) {
                break;
            } else if(arr[hi] - arr[lo] >= gap)  {// 클 때 정답값을 갱신하고 포인터를 높인다.
                answer = answer == 0 ? arr[hi] - arr[lo] : Math.min(answer, arr[hi] - arr[lo]);

                lo++;

            }
        }
        return answer;
    }

}
