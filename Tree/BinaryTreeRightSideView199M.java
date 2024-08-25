package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// https://leetcode.com/problems/binary-tree-right-side-view/
public class BinaryTreeRightSideView199M {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int size = queue.size();
            //取该层最右边的节点
            TreeNode rightMost = queue.peek();
            for(int i=0;i<size;i++){
                //取该层的左边的第一个节点
                TreeNode current = queue.poll();
                if(current.right!=null){
                    queue.offer(current.right);
                }
                if(current.left!=null){
                    queue.offer(current.left);
                }
            }
            ans.add(rightMost.val);
        }
        return ans;
    }
}
