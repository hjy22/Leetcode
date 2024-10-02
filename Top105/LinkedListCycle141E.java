package Top105;

// https://leetcode.com/problems/linked-list-cycle/?envType=study-plan-v2&envId=top-interview-150   
public class LinkedListCycle141E {
    public static void main(String[] args) {
         ListNode node1 = new ListNode(1);
        //  ListNode node2 = new ListNode(2);
        //  ListNode node3 = new ListNode(0);
        //  ListNode node4 = new ListNode(-4);
 
        //  node1.next = node2;
        //  node2.next = node3;
        //  node3.next = node4;
 
         ListNode head = node1;
        System.out.println(hasCycle(head));
    }

    public static boolean hasCycle(ListNode head) {
        if(head==null){
            return false;
        }
        ListNode slow = head;
        ListNode quick = head.next;
        while (slow!=quick) {
            if(quick==null||quick.next==null){
                return false;
            }
            slow=slow.next;
            quick=quick.next.next;
        }
        return true;
    }
}
