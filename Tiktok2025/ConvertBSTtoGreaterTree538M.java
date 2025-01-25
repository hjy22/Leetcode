package Tiktok2025;

// https://leetcode.com/problems/convert-bst-to-greater-tree/
public class ConvertBSTtoGreaterTree538M {
    public static void main(String[] args) {
        Integer[] array = { 4, 1, 6, 0, 2, 5, 7, null, null, null, 3, null, null, null, 8 };
        TreeNode root = TreeNode.arrayToTree(array);
        System.out.println(convertBST(root));
    }

    public static TreeNode convertBST(TreeNode root) {
        traverse(root);
        return root;
    }

    public static int sum = 0;

    public static void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        traverse(root.right);

        sum += root.val;
        root.val = sum;
        traverse(root.left);

    }
}
