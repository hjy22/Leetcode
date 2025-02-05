package Tiktok2025;

// https://leetcode.com/problems/binary-tree-longest-consecutive-sequence/
public class BinaryTreeLongestConsecutiveSequence298M {
    public static void main(String[] args) {
        Integer[] array = { 1, null, 3, 2, 4, null, null, null, 5 };
        TreeNode root = TreeNode.arrayToTree(array);
        System.out.println(longestConsecutive(root));
    }

    public static int longestConsecutive(TreeNode root) {
        calLength(root, root.val, 1);
        return maxLen;
    }
    static int maxLen=0;
    public static void calLength(TreeNode root,int preVal,int length ){
        if(root==null){
            return;
        }
        if(preVal==root.val-1){
            length++;
        }else{
            length=1;
        }
        maxLen = Math.max(maxLen, length);
        calLength(root.left, root.val, length);
        calLength(root.right, root.val, length);
    }

}
