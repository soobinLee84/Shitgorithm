package LTC;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LTC98 {
    boolean isValid = true;

    public boolean isValidBST(TreeNode root) {
        return search(root, root.val);
    }

    public boolean search(TreeNode root, int m) {
        if (root == null) {
            return true;
        }

        return false;

    }

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
