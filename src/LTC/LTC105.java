package LTC;

import java.util.Arrays;
import java.util.List;

public class LTC105 {

    public static void main(String[] args) {
//        buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
        buildTree(new int[]{1, 2}, new int[]{2, 1});
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {

        List<Integer> pre = Arrays.stream(preorder).boxed().toList();
        List<Integer> in = Arrays.stream(inorder).boxed().toList();

        return build(pre, in);
    }

    public static TreeNode build(List<Integer> pre, List<Integer> in) {
        if (pre.isEmpty() || in.isEmpty()) {
            return null;
        }

        // 루트의 위치 찾기
        int mid = in.indexOf(pre.get(0));
        TreeNode root = new TreeNode(pre.get(0));

        if (pre.size() == 1 || in.size() == 1) {
            return root;
        }

        root.left = build(pre.subList(1, 1 + mid), in.subList(0, mid));
        root.right = build(pre.subList(mid + 1, pre.size()), in.subList(mid + 1, in.size()));

        return root;
    }
}
