package Tiktok2025;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// https://leetcode.com/problems/next-greater-node-in-linked-list/
public class NextGreaterNodeInLinkedList1019M {
    public static void main(String[] args) {

        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;

        ListNode head = node1;

        int[] ans = nextLargerNodes(head);
        for (int i : ans) {
            System.out.print(i + " ");
        }
    }

    public static int[] nextLargerNodes(ListNode head) {
        List<Integer> value = new ArrayList<>();
        for (ListNode node = head; node != null; node = node.next) {
            value.add(node.val);
        }
        System.out.println(value);
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[value.size()];
        for (int i = value.size() - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= value.get(i)) {
                stack.pop();
            }
            ans[i] = stack.isEmpty() ? 0 : stack.peek();
            stack.push(value.get(i));
        }
        return ans;
    }
}
