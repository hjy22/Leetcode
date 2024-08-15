package Array;

import java.util.Stack;

//https://leetcode.com/problems/add-strings/
public class AddStrings415E {
    public static void main(String[] args) {
        String num1 = "6", num2 = "501";
        System.out.println(addStrings(num1, num2));
    }

    public static String addStrings(String num1, String num2) {
        int p1 = num1.length() - 1, p2 = num2.length() - 1;
        int carry = 0;
        Stack<Integer> stack = new Stack<>();
        while (p1 >= 0 || p2 >= 0 || carry > 0) {
            int n1 = (p1>=0)?(int) num1.charAt(p1) - '0':0;
            int n2 = (p2>=0)?(int) num2.charAt(p2) - '0':0;
            int sum = n1 + n2 + carry;
            carry = sum / 10;
            stack.push(sum % 10);
            p1--;
            p2--;
        }
        
        String ans = "";
        while (!stack.isEmpty()) {
            ans += stack.pop();
        }

        return ans;
    }
}
