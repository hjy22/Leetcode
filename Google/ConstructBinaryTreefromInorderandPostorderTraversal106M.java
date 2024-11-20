package Google;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreefromInorderandPostorderTraversal106M {
    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return traveseTree(postorder, 0, postorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public TreeNode traveseTree(int[] postorder, int postStart, int postEnd, int[] inorder, int inStart, int inEnd) {
        if(postStart>postEnd||inStart>inEnd){
            return null;
        }

        int index = map.get(postorder[postEnd]);
        int leftSize = index-inStart;
        TreeNode root = new TreeNode(postorder[postEnd]);

        root.left = traveseTree(postorder, postStart, postStart+leftSize-1, inorder, inStart, index-1);
        root.right = traveseTree(postorder, postStart+leftSize, postEnd-1, inorder, index+1, inEnd);

        return root;
    }
}
