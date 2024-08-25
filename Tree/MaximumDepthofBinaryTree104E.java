package Tree;

// https://leetcode.com/problems/maximum-depth-of-binary-tree/
public class MaximumDepthofBinaryTree104E {
    public static void main(String[] args) {
    }

    public static int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }
}
