package Tiktok2025;

import java.util.LinkedList;
import java.util.Queue;

public class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }

    public static Node arrayToNode(Integer[] array) {
        if (array == null || array.length == 0) {
            return null;
        }

        // 创建根节点
        Node root = new Node(array[0]);
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        int i = 1; // 从第二个元素开始处理
        while (!queue.isEmpty() && i < array.length) {
            Node current = queue.poll();

            // 处理左子节点
            if (i < array.length && array[i] != null) {
                current.left = new Node(array[i]);
                queue.offer(current.left);
            }
            i++;

            // 处理右子节点
            if (i < array.length && array[i] != null) {
                current.right = new Node(array[i]);
                queue.offer(current.right);
            }
            i++;
        }

        return root;
    }
};
