package LinkList;

//https://leetcode.com/problems/add-two-numbers/
public class AddTwoNumbersM2 {
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

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode(0);
        ListNode temp=ans;
        int carry = 0;
        while (l1 != null || l2 != null||carry!=0) {
            int num1=0;
            int num2=0;
            if (l1 != null) {
                num1 = l1.val;
            } 
            if (l2 != null) {
                num2 = l2.val;
            } 
            int sum = num1 + num2 + carry;
            if (sum >= 10) {
                sum -= 10;
                carry = 1;
            }else{
                carry = 0;
            }
            System.out.println(sum);
            ListNode node = new ListNode(sum);
            temp.next = node;
            temp = temp.next;
            if (l1 != null) {
                 l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            } 
           
            
        }
        ListNode result = ans.next;
        return result;
    }
}
