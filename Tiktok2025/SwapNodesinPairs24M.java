package Tiktok2025;

// https://leetcode.com/problems/swap-nodes-in-pairs/?envType=company&envId=tiktok&favoriteSlug=tiktok-three-months
public class SwapNodesinPairs24M {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        ListNode head = node1;
        ListNode ans = swapPairs(head);
        // ListNode.printList(ans);
        // System.out.println();
    }

    public static ListNode swapPairs(ListNode head) {
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode current = dummyNode;

        while (current.next != null && current.next.next != null) {
//fir  sec
//1    2
//sec  fir
            ListNode first = current.next;
            ListNode second = current.next.next;

            current.next = second;
            first.next = second.next;
            second.next = first;
            current = first;
        }
        return dummyNode.next;
    }
}
