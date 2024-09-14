package LTC;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LTC310 {

    public static void main(String[] args) {
        /*System.out.println(findMinHeightTrees(4, new int[][]{
                {1, 0}, {1, 2}, {1, 3}
        }));*/

        System.out.println(findMinHeightTrees(6, new int[][]{
                {3, 0}, {3, 1}, {3, 2}, {3, 4}, {5, 4}
        }));
    }

    public static List<Integer> findMinHeightTrees(int n, int[][] edges) {

        if (n == 1) return List.of(0);

        // 경로 그래프 생성
        Map<Integer, List<Integer>> g = new HashMap<>();
        for (int[] e : edges) {
            g.computeIfAbsent(e[0], a -> new ArrayList<>()).add(e[1]);
            g.computeIfAbsent(e[1], a -> new ArrayList<>()).add(e[0]);
        }

        List<Integer> leaves = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (g.get(i).size() == 1) leaves.add(i);
        }

        while (n > 2) {
            n -= leaves.size();

            List<Integer> newLeaves = new ArrayList<>();

            for (Integer l : leaves) {
                Integer val = g.get(l).get(0);
                g.get(val).remove(l);
                if (g.get(val).size() == 1) newLeaves.add(val);
            }

            leaves = newLeaves;
        }

        return leaves;
    }

    public static List<Integer> findMinHeightTrees2(int n, int[][] edges) {

        if (n == 1) return List.of(0);

        // 경로 그래프 생성
        Map<Integer, List<Integer>> g = new HashMap<>();
        for (int[] e : edges) {
            g.computeIfAbsent(e[0], a -> new ArrayList<>()).add(e[1]);
            g.computeIfAbsent(e[1], a -> new ArrayList<>()).add(e[0]);
        }

        while (g.size() > 2) {
            Map<Integer, Integer> remove = new HashMap<>();

            for (Map.Entry<Integer, List<Integer>> e : g.entrySet()) {
                if (e.getValue().size() == 1) {
                    remove.put(e.getKey(), e.getValue().get(0));
                }
            }

            for (Map.Entry<Integer, Integer> e : remove.entrySet()) {
                g.remove(e.getKey());
                g.get(e.getValue()).remove(e.getKey());
            }
        }

        return g.keySet().stream().toList();
    }


}
