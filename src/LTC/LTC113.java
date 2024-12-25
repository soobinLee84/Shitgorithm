package LTC;

import java.util.ArrayList;
import java.util.List;

public class LTC113 {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();
        search(root, targetSum, new ArrayList<>(), result);

        return result;

    }

    public void search(TreeNode root, int targetSum, List<Integer> path, List<List<Integer>> result) {

        if (root == null) {
            return;
        }

        path.add(root.val);

        if (root.left == null && root.right == null) {
            path.add(root.val);

            int sum = 0;
            for (Integer i : path) {
                sum += i;
            }

            if (sum == targetSum) {
                result.add(new ArrayList<>(path));
            }
            path.remove(path.size() - 1);

        } else {
            search(root.left, targetSum, path, result);
            search(root.right, targetSum, path, result);
        }

        path.remove(path.size() - 1);
    }

}
