package Tiktok2025;

// https://leetcode.com/problems/kth-smallest-element-in-a-bst/
public class KthSmallestElementinaBST230M {
    public static void main(String[] args) {
        Integer[] array = { 3, 1, 4, null, 2 };
        TreeNode root = TreeNode.arrayToTree(array);
        System.out.println(kthSmallest(root, 1));
    }

    public static int rank = 0;
    public static int ans = 0;

    public static int kthSmallest(TreeNode root, int k) {
        traverse(root, k);
        return ans;
    }

    public static void traverse(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        traverse(root.left, k);
        rank++;
        if (k == rank) {
            ans = root.val;
            return;
        }
        traverse(root.right, k);

    }

}
