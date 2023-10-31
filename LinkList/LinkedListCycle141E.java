package LinkList;

//https://leetcode.com/problems/linked-list-cycle/
public class LinkedListCycle141E {
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

    public boolean hasCycle(ListNode head) {
        if(head==null){
            return false;
        }

        ListNode slow = head;
        ListNode quick = head.next;
        while(slow!=quick){
            if(quick==null||quick.next==null){
                return false;
            }
            slow = slow.next;
            quick = quick.next.next;
        }
        return true;
    }
}
