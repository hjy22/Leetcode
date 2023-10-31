package LinkList;

import java.util.Stack;

public class PalindromeLinkedList234E {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,2,1};
        ListNode node = new ListNode(nums[0]);
        for(int i=1;i<nums.length;i++){
            ListNode nextNode = new ListNode(nums[i]);
            node.next = nextNode;
            node = nextNode;
        }
    }
    public static boolean isPalindrome(ListNode head) {
        Stack<Integer> stack = buildStack(head);
        while(!stack.empty()){
            if(stack.pop()!=head.val){
                return false;
            }
            head = head.next;
        }
        return true;
    }

    public static Stack<Integer> buildStack(ListNode node){
        Stack<Integer> stack = new Stack<>();
        while(node!=null){
            stack.push(node.val);
            node = node.next;
        }
        return stack;
    }   
    
}
