package Tiktok2025;

// https://leetcode.com/problems/split-linked-list-in-parts/
public class SplitLinkedListinParts725M {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);

        node1.next = node2;
        node2.next = node3;

        ListNode head = node1;
        int k = 5;
        System.out.println(splitListToParts(head, k));

    }

    public static ListNode[] splitListToParts(ListNode head, int k) {
        ListNode curNode = head;
        int length = 0;
        while (curNode != null) {
            length++;
            curNode = curNode.next;
        }

        int partSize = length / k;
        int reminder = length % k;

        ListNode[] ans = new ListNode[k];
        curNode = head;
        for (int i = 0; i < k; i++) {
            ans[i] = curNode;
            int thisSize = partSize + (i < reminder ? 1 : 0);
            for (int j = 0; j < thisSize && curNode != null; j++) {
                curNode = curNode.next;
            }
            if (curNode != null) {
                ListNode next = curNode.next;
                curNode.next = null;
                curNode = next;
            }

        }
        return ans;
    }
}
