package RoundOne2025;

// https://leetcode.com/problems/middle-of-the-linked-list/submissions/
public class MiddleoftheLinkedList876E {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        System.out.println(middleNode(node1));
    }

    public static ListNode middleNode(ListNode head) {
        ListNode quick = head;
        ListNode slow = head;
        while (quick!=null&&quick.next!=null) {
            quick = quick.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
