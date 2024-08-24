package LTC;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LTC207 {
    public boolean canFinish(int nums, int[][] preArr) {

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] p : preArr) {
            map.computeIfAbsent(p[0], k -> new ArrayList<>()).add(p[1]);
        }

        Map<Integer, Boolean> path = new HashMap<>();
        Map<Integer, Boolean> visited = new HashMap<>();
        for (Integer k : map.keySet()) {
            if (!dfs(map, k, path, visited)) {
                return false;
            }
        }

        return true;
    }

    /**
     * @param map     정보
     * @param c       탐색조건
     * @param path    경로
     * @param visited 탐색조건 (가지치기)
     * @return
     */
    public boolean dfs(Map<Integer, List<Integer>> map, int c,
                       Map<Integer, Boolean> path, Map<Integer, Boolean> visited) {

        if (path.containsKey(c)) {
            return false;
        }

        if (visited.containsKey(c)) {
            return true;
        }

        if (map.containsKey(c)) {
            path.put(c, true);

            for (Integer k : map.get(c)) {
                if (!dfs(map, k, path, visited)) {
                    return false;
                }
            }

            path.remove(c);
            visited.put(c, true);
        }

        return true;
    }
}
