package Tiktok2025;

public class PartitionList86M {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(2);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        ListNode head = node1;
        int x = 3;
        System.out.println(partition(head, x));
    }

    public static ListNode partition(ListNode head, int x) {
        ListNode smallDummy = new ListNode(0);
        ListNode smallCurrent = smallDummy;
        ListNode bigDummy = new ListNode(0);
        ListNode bigCurrent = bigDummy;

        while (head!=null) {
            if(head.val>=x){
                bigCurrent.next = new ListNode(head.val);
                bigCurrent = bigCurrent.next;
            }else{
                smallCurrent.next = new ListNode(head.val);
                smallCurrent = smallCurrent.next;
            }
            head = head.next;
        }
        smallCurrent.next = bigDummy.next;
        return smallDummy.next;
    }
}
