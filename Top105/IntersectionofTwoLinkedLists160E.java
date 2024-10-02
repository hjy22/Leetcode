package Top105;

// https://leetcode.com/problems/intersection-of-two-linked-lists/
public class IntersectionofTwoLinkedLists160E {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(8);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ListNode headA = node1;

        ListNode node11 = new ListNode(5);
        ListNode node21 = new ListNode(6);
        ListNode node31 = new ListNode(1);
        ListNode node41 = new ListNode(8);
        ListNode node51 = new ListNode(4);
        ListNode node61 = new ListNode(5);

        node11.next = node21;
        node21.next = node31;
        node31.next = node41;
        node41.next = node51;
        node51.next = node61;

        ListNode headB = node11;
        System.out.println(getIntersectionNode(headA, headB));
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode l1 = headA;
        ListNode l2 = headB;
        while (l1!=l2) {
            if(l1==null){
                l1=headB;
            }else{
                l1= l1.next;
            }
            if(l2==null){
                l2 = headA;
            }else{
                l2 =l2.next;
            }
        }
        return l1;
    }
}
