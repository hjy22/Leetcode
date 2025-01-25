package Tiktok2025;

import java.util.LinkedList;
import java.util.List;

// https://leetcode.com/problems/unique-binary-search-trees-ii/
public class UniqueBinarySearchTreesII95M {
    public static void main(String[] args) {
        System.out.println(generateTrees(3));
    }

    public static List<TreeNode> generateTrees(int n) {
        return count(1, n);
    }

    public static List<TreeNode> count(int low, int high) {
        List<TreeNode> ans = new LinkedList<>();
        if (low > high) {
            ans.add(null);
            return ans;
        }

        for (int i = low; i <= high; i++) {
            List<TreeNode> leftNode = count(low, i - 1);
            List<TreeNode> rightNode = count(i + 1, high);
            for (TreeNode left : leftNode) {
                for (TreeNode right : rightNode) {
                    TreeNode node = new TreeNode(i);
                    node.left = left;
                    node.right = right;
                    ans.add(node);
                }
            }
        }
        return ans;
    }
}
