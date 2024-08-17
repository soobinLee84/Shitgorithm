package LTC;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 973. K Closest Points to Origin
 */

public class LTC973 {

    public int[][] kClosest2(int[][] points, int k) {

        PriorityQueue<Point> q = new PriorityQueue<>(Comparator.comparingDouble(Point::getDistance));


        // 우선순위 큐에 넣고
        for (int[] p : points) {
            q.add(new Point(p));
        }

        int[][] result = new int[k][2];
        // 유클리드 거리가 가장 가까운 좌표 추출 k개
        for (int i = 0; i < k; i++) {
            result[i] = q.poll().getPoint();
        }

        return result;
    }

    class Point {
        private int[] point;
        private double distance;

        public Point(int[] point) {
            this.point = point;
            this.distance = Math.sqrt((long) point[0] * point[0] + (long) point[1] * point[1]);
        }

        public int[] getPoint() {
            return point;
        }

        public double getDistance() {
            return distance;
        }
    }

    public int[][] kClosest(int[][] points, int k) {

        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingDouble(a -> Math.sqrt((long) a[0] * a[0] + (long) a[1] * a[1]))
        );

        // 우선순위 큐에 넣고
        for (int[] p : points) {
            q.add(p);
        }

        int[][] result = new int[k][2];
        // 유클리드 거리가 가장 가까운 좌표 추출 k개
        for (int i = 0; i < k; i++) {
            result[i] = q.poll();
        }

        return result;
    }
}
