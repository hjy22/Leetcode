package Tiktok2025;

// https://leetcode.com/problems/maximum-binary-tree/
public class MaximumBinaryTree654M {
    public static void main(String[] args) {
        int[] nums = { 3, 9, 20, 15, 7 };
        System.out.println(constructMaximumBinaryTree(nums));
    }

    public static TreeNode constructMaximumBinaryTree(int[] nums) {
        return traverse(nums, 0, nums.length);
    }

    public static TreeNode traverse(int[] nums, int start, int end) {
        if (start >= end) {
            return null;
        }

        int max = nums[start], maxIndex = start;
        for (int i = start + 1; i < end; i++) {
            if (max < nums[i]) {
                max = nums[i];
                maxIndex = i;
            }
        }

        TreeNode root = new TreeNode(max);
        root.left = traverse(nums, start, maxIndex);
        root.right = traverse(nums, maxIndex+1, end);
        return root;
    }
}
