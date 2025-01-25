package Tiktok2025;

// https://leetcode.com/problems/search-in-a-binary-search-tree/description/
public class SearchinaBinarySearchTree700E {
    public static void main(String[] args) {
        Integer[] array = { 4, 2, 7, 1, 3 };
        TreeNode root = TreeNode.arrayToTree(array);
        System.out.println(searchBST(root, 2));
    }

    public static TreeNode searchBST(TreeNode root, int val) {
        return findNode(root, val);
    }

    public static TreeNode findNode(TreeNode node, int val) {
        if(node==null){
            return null;
        }
        if(node.val==val){
            return node;
        }else if(node.val<val){
            return findNode(node.right, val);
        }else{
            return findNode(node.left, val);
        }
    }
}
