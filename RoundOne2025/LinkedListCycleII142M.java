package RoundOne2025;

// https://leetcode.com/problems/linked-list-cycle-ii/description/?show=1
public class LinkedListCycleII142M {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(-4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        System.out.println(detectCycle(node1));
    }

    public static ListNode detectCycle(ListNode head) {
        ListNode quick = head;
        ListNode slow = head;
        while (quick!=null&&quick.next!=null) {
            quick = quick.next.next;
            slow = slow.next;
            if(slow==quick){
                break;
            }
        }
        if (quick == null || quick.next == null) {
            return null;
        }

        quick = head;
        while (quick!=slow) {
            quick = quick.next;
            slow = slow.next;
        }
        return slow;
    }
}
