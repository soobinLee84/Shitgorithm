package LTC;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class LTC406 {

    public int[][] reconstructQueue(int[][] people) {

        Queue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] != b[0] ? b[0] - a[0] : a[1] - b[1]);
        List<int[]> result = new ArrayList<>();

        for (int[] p : people) {
            pq.add(p);
        }

        while (!pq.isEmpty()) {
            int[] p = pq.poll();
            result.add(p[1], p);
        }

        return result.toArray(new int[people.length][2]);

    }

}
