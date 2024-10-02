package Top105;

// https://leetcode.com/problems/middle-of-the-linked-list/
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

        ListNode head = node1;
        System.out.println(middleNode(head));
    }

    public static ListNode middleNode(ListNode head) {
        ListNode slow  = head;
        ListNode fast = head;
        while (fast!=null&&fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
