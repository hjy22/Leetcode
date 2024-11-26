package Google;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// https://leetcode.com/problems/next-greater-node-in-linked-list/
public class NextGreaterNodeInLinkedList1019M {
    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        int[] ans = nextLargerNodes(head);
        for (int i : ans) {
            System.out.print(i + " ");
        }
    }

    public static int[] nextLargerNodes(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        List<Integer> arr = new ArrayList<>();
        for(ListNode node=head;node!=null;node=node.next){
            arr.add(node.val);
        }

        int[] ans = new int[arr.size()];
        for(int i=arr.size()-1;i>=0;i--){
            while (!stack.isEmpty()&&stack.peek()<=arr.get(i)) {
              stack.pop();  
            }
            ans[i]=stack.isEmpty()?0:stack.peek();
            stack.push(arr.get(i));
        }
        return ans;
    }
}
