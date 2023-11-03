package LinkList;

// https://leetcode.com/problems/odd-even-linked-list/description/
public class OddEvenList328M {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    public static void main(String[] args) {
    }

    public ListNode oddEvenList(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode firstNode = head;
        ListNode secondNode = head.next;
        ListNode secondHead = secondNode;

        while(secondNode!=null&&secondNode.next!=null){
            firstNode.next = secondNode.next;
            firstNode = firstNode.next;
            secondNode.next = firstNode.next;
            secondNode = secondNode.next;
        }
        firstNode.next=secondHead;
        return head;
    }

}
