package Top105;

// https://leetcode.com/problems/partition-list/
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
        System.out.println(partition(head,x));

    }

    public static ListNode partition(ListNode head, int x) {
        ListNode smallDummy = new ListNode();
        ListNode bigDummy = new ListNode();
        ListNode smallNode = smallDummy;
        ListNode bigNode =bigDummy;
        while (head!=null) {
            if(head.val>=x){
                bigNode.next = head;
                bigNode = bigNode.next;
            }else{
                smallNode.next = head;
                smallNode= smallNode.next;
            }
            head = head.next;
        }
        smallNode.next = bigDummy.next;
        bigNode.next= null;
        return smallDummy.next;
    }
}
