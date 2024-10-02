package Top105;

// https://leetcode.com/problems/merge-two-sorted-lists/?envType=study-plan-v2&envId=top-interview-150
public class MergeTwoSortedLists21E {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(4);

        node1.next = node2;
        node2.next = node3;

        ListNode L1 = node1;

        ListNode node11 = new ListNode(1);
        ListNode node21 = new ListNode(3);
        ListNode node31 = new ListNode(4);

        node11.next = node21;
        node21.next = node31;

        ListNode L2 = node11;

        System.out.println(mergeTwoLists(L1, L2));
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummyNode = new ListNode();
        ListNode current = dummyNode;
        while (list1!=null||list2!=null) {
            int num1 = list1==null?Integer.MAX_VALUE:list1.val;
            int num2 = list2==null?Integer.MAX_VALUE:list2.val;
            if(num1>num2){
                current.next = new ListNode(num2);
                list2 = list2.next;
            }else{
                current.next = new ListNode(num1);
                list1 = list1.next;
            }
            current = current.next;
        }
        return dummyNode.next;
    }
}
