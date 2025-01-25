package Tiktok2025;

public class FlattenBinaryTreetoLinkedList114M {
    public static void main(String[] args) {
        Integer[] array = { 1, 2, 5, 3, 4, null, 6 };
        TreeNode root = TreeNode.arrayToTree(array);
        flatten(root);
        // System.out.println();
    }

    public static void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        flatten(root.left);
        flatten(root.right);

        TreeNode left = root.left;
        TreeNode right = root.right;

        root.right = left;
        root.left = null;
        TreeNode node = root;
        while (node.right != null) {
            node = node.right;
        }
        node.right = right;
    }
}
