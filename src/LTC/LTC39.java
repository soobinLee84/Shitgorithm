package LTC;

import java.util.ArrayList;
import java.util.List;

public class LTC39 {
    public List<List<Integer>> combinationSum(int[] c, int target) {

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        dfs(result, c, 0, target, path);

        return result;
    }

    /**
     * @param result 결과
     * @param c      정보
     * @param start  탐색조건
     * @param target 종료조건
     * @param path   경로
     */
    public void dfs(List<List<Integer>> result, int[] c, int start, int target, List<Integer> path) {

        if (target < 0) {
            return;
        }

        if (target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < c.length; i++) {
            path.add(c[i]);
            dfs(result, c, i, target - c[i], path);
            path.remove(path.size() - 1);
        }

    }
}
