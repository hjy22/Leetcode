package Top105;

// https://leetcode.com/problems/reverse-linked-list-ii/?envType=study-plan-v2&envId=top-interview-150
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
        System.out.println(reverseBetween(head, left, right));
    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode node = dummyNode;
        for (int i = 1; i < left && head.next != null; i++) {
            node = node.next;
        }
        node.next = reverseIndex(node.next, right - left + 1);
        return dummyNode.next;
    }

    public static ListNode reverseIndex(ListNode head, int end) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = null, cur = head, nxt = head.next;
        while (end > 0 && cur != null) {
            cur.next = pre;
            pre = cur;
            cur = nxt;
            if (nxt != null) {
                nxt = nxt.next;
            }
            end--;
        }
        head.next = cur;

        return pre;
    }
}
