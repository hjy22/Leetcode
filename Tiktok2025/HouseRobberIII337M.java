package Tiktok2025;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/house-robber-iii/?envType=company&envId=tiktok&favoriteSlug=tiktok-three-months
public class HouseRobberIII337M {
    public static void main(String[] args) {
        Integer[] array = { 3, 2, 3, null, 3, null, 1 };
        TreeNode root = TreeNode.arrayToTree(array);
        System.out.println(rob(root));
    }

    public static Map<TreeNode, Integer> map = new HashMap<>();

    public static int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (map.containsKey(root)) {
            return map.get(root);
        }

        int rob_it = root.val + (root.left == null ? 0 : rob(root.left.left) + rob(root.left.right))
                + (root.right == null ? 0 : rob(root.right.left) + rob(root.right.right));
        int no_rob_it = rob(root.left) + rob(root.right);
        int max = Math.max(rob_it, no_rob_it);
        map.put(root, max);
        return max;
    }
}
