package LTC;

import java.util.ArrayList;
import java.util.List;

public class LTC230 {

    public int kthSmallest(TreeNode root, int k) {
        List<Integer> inOrder = new ArrayList<>();
        search(root, k, inOrder);
        return inOrder.get(k - 1);
    }

    public void search(TreeNode root, int k, List<Integer> inOrder) {
        if (root == null) {
            return;
        }

        search(root.left, k, inOrder);

        inOrder.add(root.val);
        if (inOrder.size() == k) {
            return;
        }

        search(root.right, k, inOrder);
    }

}
