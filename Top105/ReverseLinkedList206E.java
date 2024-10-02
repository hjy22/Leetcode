package Top105;

// https://leetcode.com/problems/reverse-linked-list/
public class ReverseLinkedList206E {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(4);
        ListNode node6 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        ListNode head = node1;
        System.out.println(reverseList(head));

    }

    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode pre = null, cur = head, nxt = head.next;
        while (cur!=null) {
            cur.next = pre;
            pre = cur;
            cur = nxt;
            if(nxt!=null){
                nxt = nxt.next;
            }
        }
        return pre;
    }
}
