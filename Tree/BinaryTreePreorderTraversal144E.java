package Tree;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/binary-tree-preorder-traversal/
public class BinaryTreePreorderTraversal144E {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        traverse(root, list);
        return list;
    }

    public void traverse(TreeNode root,List<Integer> list){
        if(root==null){
            return;
        }
        list.add(root.val);
        traverse(root.left, list);
        traverse(root.right, list);
    }
}
