package Tiktok2025;

// https://leetcode.com/problems/sum-root-to-leaf-numbers/
public class SumRoottoLeafNumbers129M {
    public static void main(String[] args) {
        Integer[] array = { 1, 2, 3 };
        TreeNode root = TreeNode.arrayToTree(array);
        System.out.println(sumNumbers(root));
    }

    public static int sumNumbers(TreeNode root) {
        return calSum(root, 0);
    }

    public static int calSum(TreeNode root, int curSum) {
        if (root == null) {
            return 0;
        }
        curSum = 10 * curSum + root.val;

        if (root.left == null && root.right == null) {
            return curSum;
        }

        return calSum(root.left, curSum) + calSum(root.right, curSum);
    }
}
