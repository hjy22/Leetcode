package Tiktok2025;

// https://leetcode.com/problems/merge-k-sorted-lists/
public class MergekSortedLists23M {
    public static void main(String[] args) {

        int[][] input = {
                { 1, 4, 5 },
                { 1, 3, 4 },
                { 2, 6 }
        };

        ListNode[] lists = new ListNode[input.length];
        for (int i = 0; i < input.length; i++) {
            lists[i] = createList(input[i]);
        }

        ListNode result = mergeKLists(lists);
    }

    public static ListNode createList(int[] values) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for (int value : values) {
            current.next = new ListNode(value);
            current = current.next;
        }
        return dummy.next;
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0)
            return null;
        return divideList(lists, 0, lists.length - 1);
    }

    public static ListNode divideList(ListNode[] lists, int start, int end) {
        if (start == end)
            return lists[start];
        if (start > end)
            return null;

        int mid = start + (end - start) / 2;
        ListNode left = divideList(lists, start, mid);
        ListNode right = divideList(lists, mid + 1, end);
        return mergeList(left, right);
    }

    public static ListNode mergeList(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        if (l1.val < l2.val) {
            l1.next = mergeList(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeList(l1, l2.next);
            return l2;
        }
    }
}
