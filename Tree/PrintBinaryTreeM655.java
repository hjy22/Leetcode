package Tree;

import java.util.List;
import java.util.ArrayList;

// https://leetcode.com/problems/print-binary-tree/
public class PrintBinaryTreeM655 {
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

    public List<List<String>> printTree(TreeNode root) {

        int height = getHeight(root);
        int n = (int) Math.pow(2, height + 1) - 1;
        TreeNode node = new TreeNode(n);
        TreeNode newTree = buildTree(node, height, 0, n);

        List<List<String>> result = new ArrayList<>();
        for (int i = 0; i <= height; i++) {
            List<String> list = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if (j == newTree.val) {
                    list.add(String.valueOf(root.val));
                } else {
                    list.add("");
                }
            }
            result.add(list);
        }
        return result;
    }

    public TreeNode buildMatrix(TreeNode node, int height, int r, int c) {
        if(node==null){
            return null;
        }
        TreeNode newTree = new TreeNode(node.val);
        newTree.left = buildMatrix(node.left, height, r + 1, c - (int) Math.pow(2, height - r - 1));
        newTree.right = buildMatrix(node.right, height, r + 1, c + (int) Math.pow(2, height - r - 1));
        return newTree;
    }

    public int getHeight(TreeNode root) {
        if (root == null) {
            return -1;
        }
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }
}
