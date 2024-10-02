package Top105;

// https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/?envType=study-plan-v2&envId=top-interview-150
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

        ListNode head = node1;
        System.out.println(deleteDuplicates(head));
    }

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode dummyNode = new ListNode(0);

        //基于dummyNode，遇到重复的断开link
        dummyNode.next = head;
        ListNode prev = dummyNode;
        ListNode cur=head;
        while (cur!=null) {
            //判断下一个和这一个是否是一样的
            if(cur.next!=null&&cur.val==cur.next.val){
                //一直剔除到不一样为止
                while (cur.next!=null&&cur.val==cur.next.val) {
                    cur = cur.next;
                }
                //cur到不一样的了，赋值给prev.next
                prev.next = cur.next;
            }else{
                //当前结点不重复，移动prev的指针
                prev = prev.next;
            }
            cur = cur.next;
        }
        return dummyNode.next;
    }
}
