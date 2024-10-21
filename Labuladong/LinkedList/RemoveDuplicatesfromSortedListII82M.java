package Labuladong.LinkedList;

// https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
public class RemoveDuplicatesfromSortedListII82M {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(4);
        ListNode node6 = new ListNode(4);
        ListNode node7 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;

        System.out.println(deleteDuplicates(node1));
    }

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode dummyNode = new ListNode(0);
        dummyNode.next=head;
        ListNode current = dummyNode;


        while (head != null) {
            if(head.next!=null&&head.val==head.next.val){
                while(head.next!=null&&head.val==head.next.val){
                    head = head.next;
                }
                current.next = head.next;
            }else{
                current=current.next;
            }
            head = head.next;
        }
        return dummyNode.next;
    }

}
