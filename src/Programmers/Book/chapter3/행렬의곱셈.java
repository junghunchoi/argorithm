package Programmers.Book.chapter3;

//https://programmers.co.kr/learn/courses/30/lessons/12949
public class 행렬의곱셈 {

    public static void main(String[] args) {
        
    }


    public static int[][] solution(int[][] arr1, int[][] arr2) {

        int[][] result = new int[arr1.length][arr2[0].length];

        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2[i].length; j++) {

                result[i][j] = 0;
                for (int k = 0; k < arr1[i].length; k++) {
                    result[i][j] += arr1[i][k] * arr2[k][j];
                }
                }
            }

        
        return null;
    }

}
