package Tree;

//https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
public class LowestCommonAncestorofaBinaryTree236M {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 如果当前节点为空，返回空
        if (root == null) {
            return null;
        }
        
        // 如果当前节点是 p 或 q，直接返回当前节点
        if (root == p || root == q) {
            return root;
        }
        
        // 递归搜索左子树和右子树
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        
        // 如果左右子树分别找到了 p 和 q，说明当前节点是最近公共祖先
        if (left != null && right != null) {
            return root;
        }
        
        // 否则，如果左子树找到非空，返回左子树的结果；右子树同理
        return left != null ? left : right;
    }
}
