package Tiktok2025.SecondRound;

// https://leetcode.com/problems/merge-two-sorted-lists/?envType=company&envId=tiktok&favoriteSlug=tiktok-three-months
public class MergeTwoSortedLists21E {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(4);

        node1.next = node2;
        node2.next = node3;

        ListNode list1 = node1;

        ListNode node11 = new ListNode(1);
        ListNode node21 = new ListNode(3);
        ListNode node31 = new ListNode(4);

        node11.next = node21;
        node21.next = node31;

        ListNode list2 = node11;
        System.out.println(mergeTwoLists(list1, list2));
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummyNode = new ListNode(0);
        ListNode current = dummyNode;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                current.next = new ListNode(list1.val);
                list1 = list1.next;
            } else {
                current.next = new ListNode(list2.val);
                list2 = list2.next;
            }
            current = current.next;
        }

        if (list1 != null) {
            current.next = list1;
        }
        if (list2 != null) {
            current.next = list2;
        }
        return dummyNode.next;
    }
}
