package Labuladong.LinkedList;

// https://leetcode.com/problems/intersection-of-two-linked-lists/
/*
 * 将两个listnode合在一起
 * 最后一个node如果一样，说明有交点
 */
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

        System.out.println(getIntersectionNode(node1, node11));
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode list1 = headA;
        ListNode list2 = headB;
        while (list1!=list2) {
            if(list1!=null){
                list1=list1.next;
            }else{
                list1=headB;
            }

            if(list2!=null){
                list2=list2.next;
            }else{
                list2=headA;
            }
        }
        return list1;
    }
}
