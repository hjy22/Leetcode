package Tiktok2025;

// https://leetcode.com/problems/diameter-of-binary-tree/
public class DiameterofBinaryTree543E {
    static int maxDiameter = 0;

    public static void main(String[] args) {
        Integer[] array = { 1, 2, 3, 4, 5 };
        TreeNode root = TreeNode.arrayToTree(array);
        System.out.println(diameterOfBinaryTree(root));
    }

    public static int diameterOfBinaryTree(TreeNode root) {
        maxDiameter(root);
        return maxDiameter;
    }

    public static int maxDiameter(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDiameter(root.left);
        int right = maxDiameter(root.right);
        maxDiameter = Math.max(maxDiameter, left + right);
        return Math.max(right, left) + 1;
    }
}
