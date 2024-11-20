package Google;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/binary-tree-preorder-traversal/
public class BinaryTreePreorderTraversal144E {
    public static void main(String[] args) {
    }

     public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        traverse(root, list);
        return list;
    }

    public static void traverse(TreeNode root,List<Integer> list){
        if(root==null){
            return;
        }
        list.add(root.val);
        if(root.left!=null){
            traverse(root.left, list);
        }
        if(root.right!=null){
            traverse(root.right, list);
        }
    }
}
