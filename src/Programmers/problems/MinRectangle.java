package Programmers.problems;

public class MinRectangle {

    static int[][] arr = {{60,50},{30,70},{60,30},{80,40}};

    public static void main(String[] args) {
        int max = 0;
        int min = 0;

        //
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(arr[i][0], arr[i][1]);
            min = Math.max(min,Math.min(arr[i][0], arr[i][1]));
        }


        System.out.println("결과 : " + max*min);
    }


}
