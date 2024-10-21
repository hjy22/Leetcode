package Labuladong.LinkedList;

// https://leetcode.com/problems/add-two-numbers/
public class AddTwoNumbers2M {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(3);

        node1.next = node2;
        node2.next = node3;

        ListNode node11 = new ListNode(5);
        ListNode node21 = new ListNode(6);
        ListNode node31 = new ListNode(4);

        node11.next = node21;
        node21.next = node31;

        System.out.println(addTwoNumbers(node1, node11));
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyNode = new ListNode(-1);
        ListNode current = dummyNode;

        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int num1 = l1 != null ? l1.val : 0;
            int num2 = l2 != null ? l2.val : 0;
            int ans = num1 + num2 + carry;
            current.next = new ListNode(ans % 10);
            carry = ans / 10;
            current = current.next;

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        return dummyNode.next;
    }
}
