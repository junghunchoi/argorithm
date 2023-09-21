package javaalgorithm.Programmers.Book.chapter3;

//https://programmers.co.kr/learn/courses/30/lessons/68645
//입출력 예) 4	[1,2,9,3,10,8,4,5,6,7]
public class 삼각달팽이 {

    /* 복습
        1) 2023.07.15
        2) 2023.07.26
     */

    // 아래, 오른족 왼쪽위로 이동한다는 가정하에 집합을 만든다.
    private static final int[] dx = {0, 1, -1};
    private static final int[] dy = {1, 0, -1};

    public static void main(String[] args) {

        System.out.println(addSolution(4));


    }

    // 위의 이동집합을 활용한 더 나은 풀이법
    public static int[] addSolution(int n) {

        int[][] triangle = new int[n][n];
        int v = 1;
        int x = 0;
        int y = 0;
        int d = 0;

        while (true) {
            triangle[y][x] = v++;
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (nx == n || ny == n || nx == -1 || ny == -1 || triangle[ny][nx] != 0) {
                d = (d + 1) % 3; // 아래(0) 오른쪽(1) 왼쪽위(2)
                nx = x + dx[d]; // 현재의 위치를 업데이트한다.
                ny = y + dy[d];
                if (nx == n || ny == n || nx == -1 || ny == -1 || triangle[ny][nx]!= 0) break;
            }
            x = nx;
            y = ny;
        }

        int[] result = new int[v - 1];
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                result[index++] = triangle[i][j];
            }
        }

        return result;

    }


}

