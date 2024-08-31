package LTC;

import java.util.*;

public class LTC787 {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        // 그래프 생성
        Map<Integer, Map<Integer, Integer>> g = new HashMap<>();
        for (int[] f : flights) {
            g.computeIfAbsent(f[0], x -> new HashMap<>()).put(f[1], f[2]);
        }

        // 우선순위 큐 (도착, 비용, 경유)
        Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.add(new int[]{src, 0, 0});  // 시작지점

        Map<Integer, Integer> visited = new HashMap<>();

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int key = cur[0];
            int val = cur[1];
            int count = cur[2];

            if (dst == key) {  // 도착지
                return val;
            }

            visited.put(key, count);

            if (k >= count) {
                count++;

                if (g.containsKey(key)) {
                    // 가중치 갱신
                    for (Map.Entry<Integer, Integer> e : g.get(key).entrySet()) {
                        if (!visited.containsKey(e.getKey()) || count < visited.get(e.getKey())) {
                            pq.add(new int[]{e.getKey(), val + e.getValue(), count});
                        }
                    }
                }
            }
        }

        return -1;
    }
}
