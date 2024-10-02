package Top105;

// https://leetcode.com/problems/linked-list-cycle-ii/
public class LinkedListCycleII142M {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(-4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        ListNode head = node1;
        System.out.println(detectCycle(head));
    }

    public static ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        //先找到相交的位置
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                break;
            }
        }
        if (fast == null || fast.next == null) {
            return null;
        }

        //重新指向头
        //快慢指针同步前进，相交点就是环起点
        slow = head;
        while (slow!=fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
