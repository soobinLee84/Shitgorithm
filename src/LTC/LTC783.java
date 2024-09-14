package LTC;

import java.util.Collections;
import java.util.List;

public class LTC783 {
    int pre = Integer.MAX_VALUE;

    public int minDiffInBST(TreeNode root) {

        if (root == null) {
            return Integer.MAX_VALUE;
        }

        int l = minDiffInBST(root.left);

        int min = Math.abs(pre - root.val);
        pre = root.val;

        int r = minDiffInBST(root.right);

        return Collections.min(List.of(l, min, r));
    }
}
