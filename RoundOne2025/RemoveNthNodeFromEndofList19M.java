package RoundOne2025;

// https://leetcode.com/problems/remove-nth-node-from-end-of-list/?envType=study-plan-v2&envId=top-interview-150
public class RemoveNthNodeFromEndofList19M {
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
        int n = 2;
        System.out.println(removeNthFromEnd(head, n));
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode quick = dummyNode;
        for (int i = 0; i <= n; i++) {
            quick = quick.next;
        }
        
        ListNode slow = dummyNode;
        while (quick!=null) {
            slow=slow.next;
            quick = quick.next;
        }
        slow.next = slow.next.next;
        return dummyNode.next;
    }
}