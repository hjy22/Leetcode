package Google;

// https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
public class FlattenBinaryTreetoLinkedList114M {
    public void flatten(TreeNode root) {
        if(root==null){
            return;
        }

        flatten(root.left);
        flatten(root.right);
        
        TreeNode left=root.left;
        TreeNode right=root.right;

        root.right=left;
        root.left=null;

        TreeNode p = root;
        while (p.right!=null) {
            p=p.right;
        }
        p.right=right;
    }
}
