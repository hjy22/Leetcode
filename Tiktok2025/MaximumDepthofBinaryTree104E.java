package Tiktok2025;

// https://leetcode.com/problems/maximum-depth-of-binary-tree/
public class MaximumDepthofBinaryTree104E {
    public static void main(String[] args) {
        Integer[] array = { 3, 9, 20, null, null, 15, 7 };
        TreeNode root = TreeNode.arrayToTree(array);
        System.out.println(maxDepth(root));
    }

    public static int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }
}
