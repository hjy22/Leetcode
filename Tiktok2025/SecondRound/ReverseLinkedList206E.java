package Tiktok2025.SecondRound;

// https://leetcode.com/problems/reverse-linked-list/submissions/1533245553/?envType=company&envId=tiktok&favoriteSlug=tiktok-three-months
public class ReverseLinkedList206E {
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

        reverseList(node1);
    }

    public static ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pre = null, cur = head, nxt = head.next;
        while (cur != null) {
            cur.next = pre;
            pre = cur;
            cur = nxt;
            if (nxt != null) {
                nxt = nxt.next;
            }
        }
        return pre;
    }
}
