package Tiktok2025;

// https://leetcode.com/problems/sum-of-root-to-leaf-binary-numbers/
public class SumofRootToLeafBinaryNumbers1022E {
    public static void main(String[] args) {
        Integer[] array = { 1, 0, 1, 0, 1, 0, 1 };
        TreeNode root = TreeNode.arrayToTree(array);
        System.out.println(sumRootToLeaf(root));
    }

    public static int sumRootToLeaf(TreeNode root) {
        cal(root, 0);
        return sum;
    }

    static int sum = 0;

    public static int cal(TreeNode root, int curSum) {
        if (root == null) {
            return 0;
        }
        curSum = 2 * curSum + root.val;
        if (root.left == null && root.right == null) {
            sum += curSum;
        }
        return cal(root.left, curSum) + cal(root.right, curSum);
    }
}
