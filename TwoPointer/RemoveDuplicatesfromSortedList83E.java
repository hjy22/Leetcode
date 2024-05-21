package TwoPointer;

//https://leetcode.com/problems/remove-duplicates-from-sorted-list/
public class RemoveDuplicatesfromSortedList83E {
    public static void main(String[] args) {
        ListNode head = new ListNode();
        System.out.print(deleteDuplicates(head));
    }

    
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode slow = head;
        ListNode quick = head;
        while(quick!=null){
            if(slow.val!=quick.val){
                slow.next=quick;
                slow=slow.next;
            }
            quick = quick.next;
        }
        slow.next=null;
        return head;
    }
}

  
