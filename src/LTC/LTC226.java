package LTC;

public class LTC226 {
    public TreeNode invertTree(TreeNode root) {

        if (root == null) return root;

        TreeNode l = invertTree(root.left);
        TreeNode r = invertTree(root.right);

        TreeNode now = new TreeNode(root.val);
        now.left = r;
        now.right = l;

        return now;
    }

    public TreeNode invertTree2(TreeNode root) {

        if (root != null) {
            invertTree(root.left);
            invertTree(root.right);

            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
        }

        return root;
    }
}
