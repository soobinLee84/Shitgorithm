package LTC;

import java.util.*;

public class LTC743 {

    public int networkDelayTime(int[][] times, int n, int k) {

        // 그래프 생성
        Map<Integer, Map<Integer, Integer>> g = new HashMap<>();
        for (int[] t : times) {
            g.computeIfAbsent(t[0], x -> new HashMap<>()).put(t[1], t[2]);
        }

        // 우선순위 큐
        Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.add(new int[]{k, 0});  // 시작지점

        // 시간결과 == 방문
        Map<Integer, Integer> result = new HashMap<>();

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int key = cur[0];
            int val = cur[1];

            if (!result.containsKey(key)) {
                result.put(key, val);  // 방문

                if (g.containsKey(key)) {
                    // 가중치 갱신
                    for (Map.Entry<Integer, Integer> e : g.get(key).entrySet()) {
                        pq.add(new int[]{e.getKey(), val + e.getValue()});
                    }
                }

            }
        }

        /*
        1. 모든 정점에 방문 가능 여부
        2. 모든 정점에 방문 하는 최소시간
         */
        if (result.size() == n) {
            return Collections.max(result.values());
        }

        return -1;
    }

    public int networkDelayTime2(int[][] times, int n, int k) {

        // 그래프 생성
        Map<Integer, Map<Integer, Integer>> g = new HashMap<>();
        for (int[] t : times) {
            g.computeIfAbsent(t[0], x -> new HashMap<>()).put(t[1], t[2]);
        }

        // 우선순위 큐
        Queue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(Map.Entry.comparingByValue());
        pq.add(new AbstractMap.SimpleEntry<>(k, 0));

        // 시간결과 == 방문
        Map<Integer, Integer> result = new HashMap<>();

        while (!pq.isEmpty()) {
            Map.Entry<Integer, Integer> cur = pq.poll();
            Integer key = cur.getKey();
            Integer val = cur.getValue();

            if (!result.containsKey(key)) {
                result.put(key, val);  // 방문

                if (g.containsKey(key)) {
                    // 가중치 갱신
                    for (Map.Entry<Integer, Integer> e : g.get(key).entrySet()) {
                        pq.add(new AbstractMap.SimpleEntry<>(e.getKey(), val + e.getValue()));
                    }
                }
            }
        }

        /*
        1. 모든 정점에 방문 가능 여부
        2. 모든 정점에 방문 하는 최소시간
         */
        if (result.size() == n) {
            return Collections.max(result.values());
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println("hihi");
    }
}
