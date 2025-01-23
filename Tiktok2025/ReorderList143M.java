package Tiktok2025;

import java.util.Stack;

// https://leetcode.com/problems/reorder-list/submissions/1517455578/?envType=company&envId=tiktok&favoriteSlug=tiktok-three-months
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
        ListNode p = head;
        while (p != null) {
            stack.push(p);
            p = p.next;
        }
        p = head;
        int n = stack.size();

        for(int i=0;i<n/2;i++){
            ListNode firstNode = stack.pop();
            ListNode secondNode = p.next;

            p.next = firstNode;
            firstNode.next = secondNode;
            p = secondNode;
        }
        p.next=null;
    }
}
