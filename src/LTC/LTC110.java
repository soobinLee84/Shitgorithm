package LTC;

public class LTC110 {

    public boolean isBalanced(TreeNode root) {
        return dfs(root) != -1;
    }

    public int dfs(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int l = dfs(root.left);
        int r = dfs(root.right);

        if (l == -1 || r == -1 || Math.abs(l - r) > 1) {
            return -1;
        }

        return Math.max(l, r) + 1;
    }

}
