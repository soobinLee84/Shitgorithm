package LTC;

public class LTC108 {
    public TreeNode sortedArrayToBST(int[] nums) {

        if (nums.length == 0) {
            return null;
        }

        return centerOrder(nums, 0, nums.length - 1);
    }

    public TreeNode centerOrder(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }

        int center = (start + end) / 2;

        TreeNode node = new TreeNode(nums[center]);
        node.left = centerOrder(nums, start, center - 1);
        node.right = centerOrder(nums, center + 1, end);

        return node;
    }
}
