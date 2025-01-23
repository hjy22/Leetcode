package Tiktok2025;

// https://leetcode.com/problems/reverse-linked-list-ii/
public class ReverseLinkedListII92M {
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
        int left = 2, right = 4;
        ListNode ans = reverseBetween(head, left, right);
        printList(ans);
    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode current = dummyNode;

        for (int i = 1; i < left; i++) {
            current = current.next;
        }
        current.next = reverse(current.next, right - left + 1);
        return dummyNode.next;
    }

    public static ListNode reverse(ListNode head, int length) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = null, cur = head, nxt = head.next;
        while (length > 0 && cur != null) {
            cur.next = pre;
            pre = cur;
            cur = nxt;
            if (nxt != null) {
                nxt = nxt.next;
            }
            length--;
        }
        head.next = cur;
        return pre;
    }

    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}
