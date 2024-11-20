package Google;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal/
public class ConstructBinaryTreefromPreorderandPostorderTraversal889M {
    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        for (int i = 0; i < postorder.length; i++) {
            map.put(postorder[i], i);
        }
        return traveseTree(preorder, 0, preorder.length - 1, postorder, 0, postorder.length - 1);
    }

    public TreeNode traveseTree(int[] preorder, int preStart, int preEnd, int[] postorder, int postStart, int postEnd) {
        if(postStart>postEnd){
            return null;
        }
         TreeNode root = new TreeNode(preorder[preStart]);
          if (preStart == preEnd) { 
            return root;
        }
        int secondVal = preorder[preStart+1];
        int index = map.get(secondVal);
        int leftSize = index-postStart+1;
       
       
        root.left = traveseTree(preorder, preStart+1, preStart+leftSize, postorder, postStart, index);
        root.right=traveseTree(preorder, preStart+leftSize+1, preEnd, postorder, index+1, postEnd-1);
        return root;
    }
}
