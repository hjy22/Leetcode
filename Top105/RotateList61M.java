package Top105;

// https://leetcode.com/problems/rotate-list/?envType=study-plan-v2&envId=top-interview-150
public class RotateList61M {
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
        int k = 2;
        System.out.println(rotateRight(head, k));
    }
    
    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        ListNode current = head;
        int length = 1;
        while (current != null && current.next != null) {
            current = current.next;
            length++;
        }
        // 头尾相连，且当前指针指向原链表的尾部
        current.next = head;

        //处理k值大于rotation的情况
        int rotations = k % length;
        if (rotations == 0) {
            // 断开环
            current.next = null; 
            return head;
        }

        for (int i = 0; i < length -rotations; i++) {
            current = current.next;
        }

        ListNode newHead = current.next;
        current.next = null;
        return newHead;
    }

}
