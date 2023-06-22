package Programmers.Book;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Dellll {



    public static void main(String[] args) {
        Dellll dellll = new Dellll();

        int[][] line = {{2, -1, 4}, {-2, -1, 4}, {0, -1, 1}, {5, -8, -12}, {5, 8, 12}};

        System.out.println(dellll.solution(line).toString());
    }
    private static class Point {
        public final long x, y;

        public long getX() {
            return x;
        }

        public long getY() {
            return y;
        }

        private Point(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }

    public Point insersection(long a1, long b1, long c1, long a2, long b2, long c2) {
        // x,y 구해야함.

        double x = (double) (b1 * c2 - b2 * c1) / (a1 * b2 - a2 * b1);
        double y = (double) (a2 * c1 - a1 * c2) / (a1 * b2 - a2 * b1);

        if (x % 1 != 0 || x % 1 != 0) {
            return null;
        }
        return new Point((long) x, (long) y);
    }

    public Point getMax(List<Point> points) {

        long x =  points.stream()
                .mapToLong(Point::getX)
                .max()
                .orElse(0L);

        long y =  points.stream()
                .mapToLong(Point::getY)
                .max()
                .orElse(0L);

        return new Point(x, y);

    }
    public Point getmin(List<Point> points) {

        long x =  points.stream()
                .mapToLong(Point::getX)
                .min()
                .orElse(0L);

        long y =  points.stream()
                .mapToLong(Point::getY)
                .min()
                .orElse(0L);

        return new Point(x, y);

    }

    ///

    public String[] solution(int[][] line) {



        List<Point> points = new ArrayList<>();

        for (int i = 0; i < line.length; i++) {
            for (int j = i+1; j < line.length; j++) {
                Point intersection = insersection(line[i][0], line[i][1], line[i][2]
                    , line[j][0], line[j][1], line[j][2]);

                if (intersection != null) {
                    points.add(intersection);
                }
            }
        }

        // 담을 배열의 크기를 셋팅한다.
        int width = (int) (getMax(points).x - getmin(points).x + 1);
        int height = (int) (getMax(points).y - getmin(points).y + 1);

        char[][] arr = new char[width][height];

        for (char[] row : arr) {
            Arrays.fill(row,'.');
        }




        for (Point p : points) {
            int x = (int) (p.x - getmin(points).x);
            int y = (int) (getMax(points).y - p.y);
            arr[y][x] = '*';
        }


        String[] result = new String[arr.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = new String(arr[i]);
        }

        return result;
    }

}