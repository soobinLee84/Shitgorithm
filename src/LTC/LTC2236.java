package LTC;

/**
 * 2236. Root Equals Sum of Children
 */
public class LTC2236 {

    public boolean checkTree(TreeNode root) {
        return root.val == (root.left.val + root.right.val);

    }
    
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
