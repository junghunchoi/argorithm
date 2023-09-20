package java.Programmers.problems;

//https://school.programmers.co.kr/learn/courses/30/lessons/43165
//카테고리 : DFS
public class 타겟_넘버 {

    static int answer;

    public static void main(String[] args) {

        int[] numbers = {1, 1, 1, 1, 1};

        dfs(numbers, 0, 3, 0);

        System.out.println(answer);

    }

    static void dfs(int[] numbers, int depth, int target, int sum) {

        System.out.println("Depth: " + depth + " sum :" + sum);

        if (depth == numbers.length) {
            if (sum == target) {
                answer++;
                return;
            }
        } else {
            dfs(numbers, depth + 1, target, sum + numbers[depth]);
            dfs(numbers, depth + 1, target, sum - numbers[depth]);
        }


    }
}