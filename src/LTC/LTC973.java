package LTC;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 973. K Closest Points to Origin
 */

public class LTC973 {

    /**
     * 최소힙 방식 <br>
     * 시간복잡도 : O(nlogn) / 공간복잡도 : O(n)
     * @param points
     * @param k
     * @return
     */
    public int[][] kClosest(int[][] points, int k) {

        PriorityQueue<int[]> pq = new PriorityQueue<>(
                Comparator.comparingDouble(a -> a[0] * a[0] + a[1] * a[1]));

        for (int[] p : points) {
            pq.add(p);
        }

        int[][] result = new int[k][2];
        for (int i = 0; i < result.length; i++) {
            result[i] = pq.poll();
        }

        return result;

    }

    /**
     * 최대힙 방식 <br>
     * 시간복자도 : O(nlogk) / 공간복잡도 : O(k) <br>
     * @param points
     * @param k
     * @return
     */
    public int[][] kClosest2(int[][] points, int k) {

        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> Double.compare(
                        b[0] * b[0] + b[1] * b[1],
                        a[0] * a[0] + a[1] * a[1]
                )
        );

        for (int[] p : points) {
            pq.add(p);
            if (pq.size() > k) {
                pq.poll();  // 가장 먼 점 제거
            }
        }

        int[][] result = new int[k][2];
        for (int i = 0; i < result.length; i++) {
            result[i] = pq.poll();
        }

        return result;

    }

    public int[][] kClosest4(int[][] points, int k) {

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
}
