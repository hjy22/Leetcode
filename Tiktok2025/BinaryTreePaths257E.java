package Tiktok2025;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/binary-tree-paths/
public class BinaryTreePaths257E {
    public static void main(String[] args) {
        Integer[] array = { 1, 2, 3, null, 5 };
        TreeNode root = TreeNode.arrayToTree(array);
        System.out.println(binaryTreePaths(root));
    }

    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        traverse(root, new StringBuilder(), ans);
        return ans;
    }

    public static void traverse(TreeNode root, StringBuilder path, List<String> ans) {
        if (root == null) {
            return;
        }
        int length = path.length();
        path.append(root.val);

        if (root.left == null && root.right == null) {
            ans.add(path.toString());
        } else {
            path.append("->");
            if (root.left != null) {
                traverse(root.left, path, ans);

            }
            if (root.right != null) {
                traverse(root.right, path, ans);

            }
        }
        path.setLength(length);
    }
}
