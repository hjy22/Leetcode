package Tree;

// https://leetcode.com/problems/diameter-of-binary-tree/
public class DiameterofBinaryTree543E {
    int maxDiameter=0;
    public int diameterOfBinaryTree(TreeNode root) {
         maxDiameter(root);
        return maxDiameter;
    }

    public int maxDiameter(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftMax = maxDiameter(root.left);
        int rightMax = maxDiameter(root.right);
        int thisDiameter = leftMax+rightMax;
        maxDiameter = Math.max(maxDiameter, thisDiameter);

        return 1 + Math.max(leftMax, rightMax);
    }
}
