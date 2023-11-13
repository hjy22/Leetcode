package Tree;

//https://leetcode.com/problems/balanced-binary-tree/
public class BalancedBinaryTreeE110 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public boolean isBalanced(TreeNode root) {
        if(root==null){
            return true;
        }
        boolean differ = Math.abs(getHeight(root.left)-getHeight(root.right))<=1;
        return differ && isBalanced(root.left)&&isBalanced(root.right);
    }

    private int getHeight(TreeNode root){
        if(root==null){
            return -1;
        }
        return 1+Math.max(getHeight(root.left),getHeight(root.right));
    }
}
