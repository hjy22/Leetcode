package Top105;


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

    /*
     * 想要删除第后n个node
     * 可以用快慢指针
     * 快指针比慢指针先走n步
     * 当快指针到达最后时
     * 慢指针指向的就是要删除的
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode node = getNthFromEnd(dummyNode, n);
        node.next=node.next.next;
        return dummyNode.next;
    }

    public static ListNode getNthFromEnd(ListNode head, int n) {
        ListNode slow = head;
        ListNode fast = head;
        while (n>=0) {
            fast = fast.next;
            n--;
        }
        while (fast!=null) {
            slow=slow.next;
            fast=fast.next;
        }
        return slow;
    }
}
