package Labuladong.LinkedList;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/remove-duplicates-from-an-unsorted-linked-list/
public class RemoveDuplicatesFromanUnsortedLinkedList1836M {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(2);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        System.out.println(deleteDuplicatesUnsorted(node1));
    }

    public static ListNode deleteDuplicatesUnsorted(ListNode head) {
            Map<Integer, Integer> map = new HashMap<>();
            ListNode saveNode = head;
            while (saveNode != null) {
                int num = saveNode.val;
                map.put(num, map.getOrDefault(num, 0) + 1);
                saveNode = saveNode.next;
            }

            ListNode dummyNode = new ListNode(0);
            ListNode current = dummyNode;
            while (head != null) {
                int num = head.val;
                int times = map.get(num);
                if (times == 1) {
                    current.next = new ListNode(num);
                    current = current.next;
                }
                head=head.next;
            }
            return dummyNode.next;
    }
}
