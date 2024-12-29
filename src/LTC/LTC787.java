package LTC;

import java.util.*;

public class LTC787 {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // 출발, 도착, 비용
        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
        for (int[] f : flights) {
            graph.computeIfAbsent(f[0], a -> new HashMap<>()).put(f[1], f[2]);
        }

        // 도착, 비용, 경유
        Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{src, 0, 0});

        // 도착, 경유
        int[] visited = new int[n];

        while (!pq.isEmpty()) {
            int[] cur = pq.poll(); // 최소비용이면서
            int key = cur[0];
            int price = cur[1];
            int count = cur[2];

            // 도착
            if (key == dst) {
                return price;
            }

            visited[key] = count;

            if (count <= k) {
                count++;

                if (graph.containsKey(key)) {
                    for (Map.Entry<Integer, Integer> e : graph.get(key).entrySet()) {

                        // 방문하지 않았거나 경유지수가 작은 경우 가중치 갱신
                        if (visited[e.getKey()] == 0 || count < visited[e.getKey()]) {
                            pq.add(new int[]{e.getKey(), price + e.getValue(), count});
                        }
                    }
                }
            }
        }

        return -1;
    }


    public int findCheapestPrice2(int n, int[][] flights, int src, int dst, int k) {

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
