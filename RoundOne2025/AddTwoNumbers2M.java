package RoundOne2025;

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
        ListNode dummyNode = new ListNode(0);
        ListNode current = dummyNode;

        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int i1 = l1 == null ? 0 : l1.val;
            int i2 = l2 == null ? 0 : l2.val;

            int sum = i1 + i2 + carry;
            carry = sum / 10;
            current.next = new ListNode(sum % 10);
            current = current.next;
            l1 = l1 == null ? null :l1.next;
            l2 = l2 == null ? null :l2.next;
        }
        return dummyNode.next;
    }
}
