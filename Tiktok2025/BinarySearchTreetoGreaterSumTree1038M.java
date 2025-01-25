package Tiktok2025;

// https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/
public class BinarySearchTreetoGreaterSumTree1038M {
    public static void main(String[] args) {
        Integer[] array = { 4, 1, 6, 0, 2, 5, 7, null, null, null, 3, null, null, null, 8 };
        TreeNode root = TreeNode.arrayToTree(array);
        System.out.println(bstToGst(root));
    }

    public static int sum = 0;

    public static TreeNode bstToGst(TreeNode root) {
        traverse(root);
        return root;
    }

    public static void traverse(TreeNode root) {
        if(root==null){
            return;
        }
        traverse(root.right);
        sum+=root.val;
        root.val = sum;
        traverse(root.left);
    }
}
