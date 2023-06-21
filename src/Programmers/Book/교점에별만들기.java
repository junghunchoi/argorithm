package Programmers.Book;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

//https://programmers.co.kr/learn/courses/30/lessons/87377
public class 교점에별만들기 {

    /* flow
    1. 모든 직선 쌍에 대해 반복

        A. 교점 좌표 구하기

        B. 정수 좌표만 저장

    2. 저장된 정수들에 대해 x, y 좌표의 최댓값, 최솟값 구하기

    3. 구한 최댓값, 최솟값을 이용하여 2차원 배열의 크기 결정

    4. 2차원 배열에 별 표시

    5. 문자열 배열로 변환 후 반환
    */

    public String[] solution(int[][] line) {

        List<point> points = new ArrayList<>();

        for (int i = 0; i < line.length; i++) {
            for (int j = i+1; j < line.length; j++) {
                // 모든 직선 쌍에 대해 교점을 구해야함.
                point intersection = intersection(line[i][0], line[i][1], line[i][2]
                                                , line[j][0], line[j][1], line[j][2]);

                // 객체가 넘어왔을 때 교점을 저장한다.
                if (intersection != null) {
                    points.add(intersection);
                }
            }
        }

        point minimum = getMinimumPoint(points);
        point maximum = getMaximumPoint(points);

        // 구한 교점에 2차원 배열의 크기를 정한다.
        int width = (int)(maximum.x - minimum.x + 1);
        int height = (int)(maximum.y - minimum.y + 1);

        char[][] arr = new char[height][width];

        for (char[] row : arr) {
            Arrays.fill(row, '.');
        }

        // 일반 좌표계와 2차원 배열에서 좌표를 찍을 때 값을 보정해야한다.
        for (point p : points) {
            int x = (int) (p.x - minimum.x);
            int y = (int) (maximum.y - p.y);
            arr[y][x] = '*';
        }

        // 문자열 배열로 반환한 후 반환한다.
        String[] result = new String[arr.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = new String(arr[i]);
        }
        return result;
    }

    private point getMinimumPoint(List<point> points) {
        // 교점 중 가장 작은 x,y 값찾기

        long x = Long.MAX_VALUE;
        long y = Long.MAX_VALUE;

        for (point p : points) {
            if(p.x < x ) x = p.x;
            if(p.y < y ) y = p.y;
        }

//        return new point(x,y);
        // 아래는 람다식으로 한것이다.

        return points.stream()
                     .min(Comparator.comparing(point::getX).thenComparing(point::getY))
                     .orElse(null);
    }

    private point getMaximumPoint(List<point> points) {
        // 교점 중 가장 큰 x,y 값찾기

        long x = Long.MAX_VALUE;
        long y = Long.MAX_VALUE;

        for (point p : points) {
            if(p.x > x ) x = p.x;
            if(p.y > y ) y = p.y;
        }

        return new point(x,y);

    }

    private point intersection(long a1, long b1, long c1, long a2, long b2, long c2) {
        // 교점 구해서 반환하기
        // a1x + b1y + c1 = 0 , a2x + b2y + c2 = 0 의 교점을 구하는 공식은 아래와 같다.
        // 이런 방정식은 참고로 주어지니 알아둘 필요는 없다.
        double x = (double) (b1 * c2 - b2 * c1) / (a1 * b2 - a2 * b1);
        double y = (double) (a2 * c1 - a1 * c2) / (a1 * b2 - a2 * b1);

        // 정수로 떨어지지 않으면 리턴
        if(x % 1 != 0 || y% 1 != 0) return null;
        return new point((long) x, (long) y);
    }

    private static class point{

        public final long x,y;

        public long getX() {
            return x;
        }

        public long getY() {
            return y;
        }

        public point(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }
}
