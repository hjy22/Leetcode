package RoundOne2025;

import java.util.Stack;

// https://leetcode.com/problems/add-two-numbers-ii/
public class AddTwoNumbersII445M {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(7);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(3);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        ListNode node11 = new ListNode(5);
        ListNode node21 = new ListNode(6);
        ListNode node31 = new ListNode(4);

        node11.next = node21;
        node21.next = node31;

        System.out.println(addTwoNumbers(node1, node11));
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        while (l1 != null) {
            stack1.push(l1.val);
            l1=l1.next;
        }
        while (l2 != null) {
            stack2.push(l2.val);
            l2=l2.next;
        }

        Stack<Integer> stack3 = new Stack<>();
        int carry=0;
        
        while (!stack1.isEmpty()||!stack2.isEmpty()||carry!=0) {
            int i1 = stack1.isEmpty()?0:stack1.pop();
            int i2 = stack2.isEmpty()?0:stack2.pop();

            int sum = i1+i2+carry;
            carry = sum/10;
            stack3.push(sum%10);
        }

        ListNode dummyNode = new ListNode(0);
        ListNode current = dummyNode;
        while (!stack3.isEmpty()) {
            current.next = new ListNode(stack3.pop());
            current = current.next;
        }
        return dummyNode.next;
    }
}
