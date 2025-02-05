package Tiktok2025;

// https://leetcode.com/problems/find-distance-in-a-binary-tree/
public class FindDistanceinaBinaryTree1740M {
    public static void main(String[] args) {
        Integer[] array = { 3, 5, 1, 6, 2, 0, 8, null, null, 7, 4 };
        int p = 5, q = 0;
        TreeNode root = TreeNode.arrayToTree(array);
        System.out.println(findDistance(root, p, q));
    }

    public static int findDistance(TreeNode root, int p, int q) {
        TreeNode lca = findLCA(root, p, q);
        int pDepth = getDepth(lca, p,0);
        int qDepth = getDepth(lca, q, 0);
        return pDepth+qDepth;
    }

    public static TreeNode findLCA(TreeNode root, int p, int q){
        if(root==null||root.val==p||root.val==q){
            return root;
        }
        TreeNode left = findLCA(root.left, p, q);
        TreeNode right = findLCA(root.right, p, q);
        if(left!=null&&right!=null){
            return root;
        }
        return left!=null?left:right;
    }

    public static int getDepth(TreeNode root, int target,int depth){
        if(root==null){
            return -1;
        }
        if(root.val==target){
            return depth;
        }
        int leftDepth = getDepth(root.left, target, depth+1);
        if(leftDepth!=-1){
            return leftDepth;
        }
        return getDepth(root.right, target, depth+1);
    }
}
