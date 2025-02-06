package Tiktok2025.SecondRound;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// https://leetcode.com/problems/next-greater-node-in-linked-list/
public class NextGreaterNodeInLinkedList1019M {
    public static void main(String[] args) {

        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;

        ListNode head = node1;

        int[] ans = nextLargerNodes(head);
        for (int i : ans) {
            System.out.print(i + " ");
        }
    }

    public static int[] nextLargerNodes(ListNode head) {
        Stack<Integer> nextLargeStack = new Stack<>();
        List<Integer> nodeVal = new ArrayList<>();
        for(ListNode node = head;node!=null;node=node.next){
            nodeVal.add(node.val);
        }

        int[] ans = new int[nodeVal.size()];
        for(int i=nodeVal.size()-1;i>=0;i--){
            while (!nextLargeStack.isEmpty()&&nextLargeStack.peek()<=nodeVal.get(i)) {
                nextLargeStack.pop();
            }
            ans[i]=nextLargeStack.isEmpty()?0:nextLargeStack.peek();
            nextLargeStack.push(nodeVal.get(i));
        }
        return ans;
    }
}
