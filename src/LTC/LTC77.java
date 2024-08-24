package LTC;

import java.util.ArrayList;
import java.util.List;

public class LTC77 {

    public List<List<Integer>> combine(int n, int k) {

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        dfs(result, n, 1, k, list);

        return result;

    }

    /**
     * @param result 결과
     * @param n      정보
     * @param start  탐색조건
     * @param k      종료조건
     * @param path   경로
     */
    public void dfs(List<List<Integer>> result, int n, int start, int k, List<Integer> path) {

        if (k == 0) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i <= n; i++) {
            path.add(i);
            dfs(result, n, i + 1, k - 1, path);
            path.remove(path.size() - 1);
        }
    }
}
