package LinkList;

//https://leetcode.com/problems/middle-of-the-linked-list/
public class MiddleLinkedList876E {
    public class ListNode {
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

    public void main(String[] args) {
        ListNode node = new ListNode();
        int[] nums = {1,2,3,4,5};
        for(int i=0;i<nums.length;i++){
            node.next =  new ListNode(nums[i]);
            node = node.next;
        }
        ListNode ans = middleNode(node);
        System.out.println(ans.val);
    }

    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode quick = head;
        while(quick!=null && quick.next!=null){
            slow = slow.next;
            quick = quick.next.next;
        }
        return slow;
    }
}
