package LTC;

public class LTC687 {
    int max = 0;

    public int longestUnivaluePath(TreeNode root) {
        dfs(root);
        return this.max;
    }

    public int dfs(TreeNode root) {
        if (root == null) return -1;

        int l = dfs(root.left);
        int r = dfs(root.right);

        if (root.left != null && root.left.val == root.val) {
            l++;
        } else {
            l = 0;
        }

        if (root.right != null && root.right.val == root.val) {
            r++;
        } else {
            r = 0;
        }

        this.max = Math.max(this.max, l + r);
        return Math.max(l, r);
    }


}
