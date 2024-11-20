package Google;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreefromPreorderandInorderTraversal105M {
    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return traveseTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public TreeNode traveseTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        int index = map.get(preorder[preStart]);
        int leftTreeSize = index - inStart;

        root.left = traveseTree(preorder, preStart + 1, preStart + leftTreeSize, inorder, inStart, index - 1);
        root.right = traveseTree(preorder, preStart + leftTreeSize + 1, preEnd, inorder, index + 1, inEnd);

        return root;
    }
}
