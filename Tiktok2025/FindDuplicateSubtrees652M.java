package Tiktok2025;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.com/problems/find-duplicate-subtrees/
public class FindDuplicateSubtrees652M {
    public static Map<String, Integer> map = new HashMap<>();
    public static List<TreeNode> ans = new ArrayList<>();

    public static void main(String[] args) {
        Integer[] array = { 1, 2, 3, 4, null, 2, 4, null, null, 4 };
        TreeNode root = TreeNode.arrayToTree(array);
        System.out.println(findDuplicateSubtrees(root));
    }

    public static List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        traverse(root);
        return ans;
    }

    public static String traverse(TreeNode root) {
        if (root == null) {
            return "#";
        }
        String left = traverse(root.left);
        String right = traverse(root.right);

        String thisBranch = left + "," + right + "," + root.val;
        int freq = map.getOrDefault(thisBranch, 0);
        if (freq == 1) {
            ans.add(root);
        }
        map.put(thisBranch, freq + 1);
        return thisBranch;
    }

}
