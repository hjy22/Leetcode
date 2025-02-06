package Tiktok2025.SecondRound;

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

        swapPairs(node1);
    }

    public static ListNode swapPairs(ListNode head) {
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode curNode = dummyNode;
        while (curNode.next!=null&&curNode.next.next!=null) {
            ListNode firstNode = curNode.next;
            ListNode secondNode = curNode.next.next;

            curNode.next=secondNode;
            firstNode.next=secondNode.next;
            secondNode.next=firstNode;
            curNode = firstNode;
        }
        return dummyNode.next;
    }
}
