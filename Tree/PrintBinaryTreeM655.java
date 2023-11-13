package Tree;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

// https://leetcode.com/problems/print-binary-tree/
public class PrintBinaryTreeM655 {
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

    public List<List<String>> printTree(TreeNode root) {
        int height = getHeight(root);
        int n = (int) Math.pow(2, height) - 1;
        String[][] matrix = new String[height][n];
        for(String[] row : matrix){
            Arrays.fill(row,"");
        }
        buildTree(matrix, root,0, 0, n-1);
        List<List<String>> list = new ArrayList<>();
        for(String[] row:matrix){
            list.add(Arrays.asList(row));
        }
        return list;
    }

    public void buildTree(String[][] matrix,TreeNode node,int row,int left, int right){
        if (node==null){
            return;
        }
        int mid = left+(right-left)/2;
        matrix[row][mid]=String.valueOf(node.val);
        buildTree(matrix,node.left,row+1,left,mid-1);
        buildTree(matrix,node.right,row+1,mid+1,right);
    }

    public int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }
}
