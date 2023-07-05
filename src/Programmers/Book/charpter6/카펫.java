package Programmers.Book.charpter6;


//https://school.programmers.co.kr/learn/courses/30/lessons/42842
public class 카펫 {

    public static void main(String[] args) {

        int brown = 24;
        int yellow = 24;

        solution(brown, yellow);


    }

    public static int[] solution(int brown, int yellow) {
        // 가운데 크기
        // 외각 격자 = (w-h-2)*2
        // 내각 격자 = w*h - 외각격자

        for (int height = 0; height < brown; height++) {
            for (int width = 0; width < brown; width++) {
                int browncheck = (height - width - 2) * 2;
                int yellowcheck = height * width - browncheck;

                if (browncheck == brown && yellowcheck == yellow) {
                    return new int[]{height,width};
                }
            }
        }
        return null;
    }

}
