package Tiktok2025.SecondRound;

import java.util.Stack;

// https://leetcode.com/problems/reorder-list/description/?envType=company&envId=tiktok&favoriteSlug=tiktok-three-months
public class ReorderList143M {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        reorderList(node1);
    }

    public static void reorderList(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode curNode = head;
        while (curNode != null) {
            stack.push(curNode);
            curNode = curNode.next;
        }
        int length = stack.size();
        curNode = head;
        for (int i = 0; i < length / 2; i++) {
            ListNode first = stack.pop();
            ListNode second = curNode.next;

            curNode.next = first;
            curNode = curNode.next;
            curNode.next = second;
            curNode = curNode.next;
        }
        curNode.next = null;
    }
}
