package Tiktok2025;

// https://leetcode.com/problems/validate-binary-search-tree/description/
public class ValidateBinarySearchTree98M {
    public static void main(String[] args) {
        Integer[] array = { 2, 1, 3 };
        TreeNode root = TreeNode.arrayToTree(array);
        System.out.println(isValidBST(root));
    }

    public static boolean isValidBST(TreeNode root) {
        return checkValid(root, null, null);
    }

    public static boolean checkValid(TreeNode root, TreeNode min, TreeNode max) {
        if (root == null) {
            return true;
        }
        if (min != null && root.val <= min.val) {
            return false;
        }
        if (max != null && root.val >= max.val) {
            return false;
        }
        return checkValid(root.left, min, root) && checkValid(root.right, root, max);
    }
}
