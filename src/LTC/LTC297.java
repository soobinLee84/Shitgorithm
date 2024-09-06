package LTC;

import java.util.LinkedList;
import java.util.Queue;

public class LTC297 {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";

        // BFS 반복문 큐

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        StringBuilder sb = new StringBuilder();
        sb.append("#, ").append(root.val);

        while (!q.isEmpty()) {
            TreeNode node = q.poll();

            if (node.left != null) {
                sb.append(", ").append(node.left.val);
                q.add(node.left);
            } else {
                sb.append(", #");
            }

            if (node.right != null) {
                sb.append(", ").append(node.right.val);
                q.add(node.right);
            } else {
                sb.append(", #");
            }
        }

        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if ("".equals(data)) return null;

        String[] d = data.split(", ");
        int index = 1;

        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(d[index++]));
        q.add(root);

        while (!q.isEmpty()) {
            TreeNode node = q.poll();

            if ("#".equals(d[index])) {
                node.left = null;
            } else {
                node.left = new TreeNode(Integer.parseInt(d[index]));
                q.add(node.left);
            }
            index++;

            if ("#".equals(d[index])) {
                node.right = null;
            } else {
                node.right = new TreeNode(Integer.parseInt(d[index]));
                q.add(node.right);
            }
            index++;
        }

        return root;

    }
}
