package LTC;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LTC310 {

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) return List.of(0);

        Map<Integer, List<Integer>> g = new HashMap<>();

        // 무방향 경로 그래프 생성
        for (int[] e : edges) {
            g.computeIfAbsent(e[0], k -> new ArrayList<>()).add(e[1]);
            g.computeIfAbsent(e[1], k -> new ArrayList<>()).add(e[0]);
        }

        // 리프 노드 찾기
        List<Integer> leaf = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (g.get(i).size() == 1) {  //부모노드
                leaf.add(i);
            }
        }

        while (n > 2) {
            n -= leaf.size();

            List<Integer> newLeaf = new ArrayList<>();

            for (Integer l : leaf) {
                int parent = g.get(l).get(0);
                g.get(parent).remove(l);
                if (g.get(parent).size() == 1) {
                    newLeaf.add(parent);
                }
            }

            leaf = newLeaf;
        }

        return leaf;
    }

    public static List<Integer> findMinHeightTrees1(int n, int[][] edges) {

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
