package Tiktok2025;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// https://leetcode.com/problems/binary-tree-right-side-view/
public class BinaryTreeRightSideView199M {
    public static void main(String[] args) {
        Integer[] array = { 1, 2, 3, null, 5, null, 4 };
        TreeNode root = TreeNode.arrayToTree(array);
        System.out.println(rightSideViewBFS(root));
        System.out.println(rightSideViewDFS(root));
    }

    public static List<Integer> rightSideViewBFS(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root==null){
            return ans;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0;i<size;i++){
                TreeNode node = queue.poll();
                if(i==size-1){
                    ans.add(node.val);
                }
                if(node.left!=null){
                    queue.offer(node.left);
                }
                if(node.right!=null){
                    queue.offer(node.right);
                }
            }
        }
        return ans;
    }

    public static List<Integer> rightSideViewDFS(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        DFS(root, ans, 0);
        return ans;
    }

    public static void DFS(TreeNode root,List<Integer> ans,int depth){
        if(root==null){
            return ;
        }
        if(depth==ans.size()){
            ans.add(root.val);
        }
        DFS(root.right, ans, depth+1);
        DFS(root.left, ans, depth+1);
    }
}
