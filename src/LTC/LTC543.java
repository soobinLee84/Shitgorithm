package LTC;

public class LTC543 {
    int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return this.max;
    }

    public int dfs(TreeNode root) {
        if (root == null) return -1;

        int l = dfs(root.left);
        int r = dfs(root.right);

        // 경로 = 왼쪽 리프부터 거리 + 오른쪽 리프부터 거리 + 2
        this.max = Math.max(this.max, l + r + 2);
        return Math.max(l, r) + 1;
    }
}
