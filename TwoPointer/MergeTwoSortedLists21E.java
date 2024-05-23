package TwoPointer;

public class MergeTwoSortedLists21E {
    public static void main(String[] args) {
    }
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode newList = new ListNode();
        ListNode ans = newList;

        while (list1 != null && list2 != null) {
            if (list1.val > list2.val) {
                ans.next = list2;
                list2 = list2.next;
            } else {
                ans.next = list1;
                list1 = list1.next;
            }
            ans = ans.next;
        }

        ans.next = (list1 != null) ? list1 : list2;

        return newList.next;    
    }
}
