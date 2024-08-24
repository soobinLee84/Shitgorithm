package LTC;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LTC46 {

    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        List<Integer> ns = Arrays.stream(nums).boxed().toList();
        List<Integer> path = new ArrayList<>();
        dfs(result, ns, path);

        return result;

    }

    /**
     * @param result 결과
     * @param nums   탐색조건
     * @param path   경로
     */
    public void dfs(List<List<Integer>> result, List<Integer> nums, List<Integer> path) {

        if (nums.isEmpty()) {
            result.add(new ArrayList<>(path));
        }

        for (Integer n : nums) {
            List<Integer> ns = new ArrayList<>(nums);  // nums는 불변배열
            ns.remove(n);

            path.add(n);
            dfs(result, ns, path);
            path.remove(n);
        }

    }

}
