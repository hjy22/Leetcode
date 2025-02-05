package Tiktok2025;

// https://leetcode.com/problems/pseudo-palindromic-paths-in-a-binary-tree/
public class PseudoPalindromicPathsinaBinaryTree1457M {
    public static void main(String[] args) {
        Integer[] array = { 2, 3, 1, 3, 1, null, 1 };
        TreeNode root = TreeNode.arrayToTree(array);
        System.out.println(pseudoPalindromicPaths(root));
    }

    public static int pseudoPalindromicPaths(TreeNode root) {
        traverse(root);
        return ans;
    }

    static int[] count = new int[10];
    static int ans = 0;

    public static void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        count[root.val]++;

        if (root.left == null && root.right == null) {
            if (isPseudoPalindromic(count)) {
                ans++;
            }
            count[root.val]--;
            return;
        }
        traverse(root.left);
        traverse(root.right);
        count[root.val]--;
    }

    public static boolean isPseudoPalindromic(int[] count) {
        boolean hasOdd = false;
        for (int i = 0; i < count.length; i++) {
            int num = count[i];
            if (num % 2 != 0) {
                if (!hasOdd) {
                    hasOdd = true;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

}
