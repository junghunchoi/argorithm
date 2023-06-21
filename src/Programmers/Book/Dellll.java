package Programmers.Book;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Dellll {
    private static class Point {
        public final long x, y;

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

        points.stream().map()
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


        return null;
    }

}
