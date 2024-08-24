package LTC;

import java.util.ArrayList;
import java.util.List;

public class LTC78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        List<Integer> path = new ArrayList<>();
        dfs(result, nums, 0, path);

        return result;
    }

    /**
     * @param result 결과
     * @param nums   정보
     * @param start  탐색조건
     * @param path   경로
     */
    public void dfs(List<List<Integer>> result, int[] nums, int start, List<Integer> path) {
        result.add(new ArrayList<>(path));

        for (int i = start; i < nums.length; i++) {
            path.add(nums[i]);
            dfs(result, nums, i + 1, path);
            path.remove(path.size() - 1);
        }
    }
}
