package Programmers.Book.chapter12;

import java.util.LinkedList;
import java.util.Queue;

// 게임 맵 최단거리
public class 게임_맵_최단거리 {

    /*
    1. 방문했던 곳은 들리지 않기
    2. 앞뒤좌우로 갈 때 주어진 배열의 크기 안에서 이동이 가능

    ----
    1. 큐를 통해 답을 체크해본다.
    2. 한 노드에서 4방향으로 이동하기 위한 방법을 찾아야한다.
    3. 들렸던 곳을 재방문하지 않기 위해선 boolean 배열을 통해 체크한다.
    4. queue등을 사용할 땐 while 사용을 검토해야한다.
    */

    public static void main(String[] args) {

        int[][] numbers = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};

        System.out.println(solution(numbers));
    }

    // 메인 메소드 시작
    public static int solution(int[][] map) {

        int rowLength = map.length;
        int colLength = map[0].length;

        int[] rowMove = {1, -1, 0, 0};
        int[] colMove = {0, 0, 1, -1};

        boolean[][] visited = new boolean[rowLength][colLength];

        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {
                if (map[i][j] == 0) {
                    visited[i][j] = true;
                }
            }
        }

        Queue<Node> queue = new LinkedList<>();
        visited[0][0] = true;
        queue.offer(new Node(0, 0, 1));

        int min = Integer.MAX_VALUE;

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            for (int i = 0; i < 4; i++) {
                int row = node.row + rowMove[i];
                int col = node.col + colMove[i];

                // 방문하지 않는 경우
                if (rowLength <= row || row < 0 || colLength <= col || col < 0) continue;
                if (visited[row][col] == true) continue;

                visited[row][col] = true;

                queue.offer(new Node(row, col, node.move + 1));
                System.out.println(node.toString());

                if (row == rowLength - 1 && col == colLength - 1) {
                    min = Math.min(min, node.move + 1);
                }
            }
        }
        return min == Integer.MAX_VALUE ?  -1 : min;
    }

    static class Node {

        public Node(int row, int col, int move) {
            this.row = row;
            this.col = col;
            this.move = move;
        }

        @Override
        public String toString() {
            return "Node{" + "row=" + row + ", col=" + col + ", move=" + move + '}';
        }

        int row;
        int col;
        int move;
    }


}
