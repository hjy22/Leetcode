package Tiktok2025;

// https://leetcode.com/problems/invert-binary-tree/
public class InvertBinaryTree226E {
    public static void main(String[] args) {
        Integer[] array = { 4, 2, 7, 1, 3, 6, 9 };
        TreeNode root = TreeNode.arrayToTree(array);
        System.out.println(invertTree(root));
    }

    public static TreeNode invertTree(TreeNode root) {
        traverse(root);
        return root;
    }

    public static void traverse(TreeNode root){
        if(root==null){
            return;
        }
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        traverse(root.left);
        traverse(root.right);
    }
}
