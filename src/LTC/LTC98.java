package LTC;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LTC98 {

    public boolean isValidBST(TreeNode root) {
        return valid(root, null, null);
    }

    public boolean valid(TreeNode root, Integer min, Integer max) {
        if (root == null) {
            return true;
        }

        if ((min != null && root.val <= min) || (max != null && root.val >= max)) {
            return false;
        }

        return valid(root.left, min, root.val) && valid(root.right, root.val, max);
    }


    boolean isValid = true;
    public int[] search2(TreeNode root) {

        List<Integer> min = new ArrayList<>();
        List<Integer> max = new ArrayList<>();

        min.add(root.val);
        max.add(root.val);

        if (root.left != null) {
            int[] l = search2(root.left);
            if (l[1] >= root.val) this.isValid = false;
            min.add(l[0]);
            max.add(l[1]);
        }

        if (root.right != null) {
            int[] r = search2(root.right);
            if (r[0] <= root.val) this.isValid = false;
            min.add(r[0]);
            max.add(r[1]);
        }

        return new int[]{Collections.min(min), Collections.max(max)};
    }
}
