package Tiktok2025;

// https://leetcode.com/problems/delete-node-in-a-bst/
public class DeleteNodeinaBST450M {
    public static void main(String[] args) {
        Integer[] array = { 5, 3, 6, 2, 4, null, 7 };
        TreeNode root = TreeNode.arrayToTree(array);
        System.out.println(deleteNode(root, 3));
    }

    public static TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        if (root.val == key) {
            // s1: no child
            if (root.left == null && root.right == null) {
                return null;
            }

            // s2: 1 child
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }

            // s3: two children
            TreeNode minNode = getMin(root.right);
            root.right = deleteNode(root.right, minNode.val);
            minNode.left = root.left;
            minNode.right = root.right;
            root = minNode;

        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else if (root.val > key) {
            root.left = deleteNode(root.left, key);
        }
        return root;
    }

    public static TreeNode getMin(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
}
