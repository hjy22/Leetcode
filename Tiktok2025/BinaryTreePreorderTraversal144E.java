package Tiktok2025;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/binary-tree-preorder-traversal/
public class BinaryTreePreorderTraversal144E {
    public static void main(String[] args) {
        Integer[] array = { 1, 2, 3, 4, 5, null, 8, null, null, 6, 7, 9 };
        TreeNode root = TreeNode.arrayToTree(array);
        System.out.println(preorderTraversal(root));
    }

    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        traverse(root, list);
        return list;
    }

    public static void traverse(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        list.add(node.val);
        traverse(node.left, list);
        traverse(node.right, list);
    }
}
