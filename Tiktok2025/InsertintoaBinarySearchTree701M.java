package Tiktok2025;

// https://leetcode.com/problems/insert-into-a-binary-search-tree/
public class InsertintoaBinarySearchTree701M {
    public static void main(String[] args) {
        Integer[] array = { 4, 2, 7, 1, 3 };
        TreeNode root = TreeNode.arrayToTree(array);
        System.out.println(insertIntoBST(root, 5));
    }

    public static TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (root.val < val) {
            root.right = insertIntoBST(root.right, val);
        }
        if (root.val > val) {
            root.left = insertIntoBST(root.left, val);
        }
        return root;
    }
}
