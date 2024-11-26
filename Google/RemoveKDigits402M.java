package Google;

import java.util.Stack;

// https://leetcode.com/problems/remove-k-digits/
public class RemoveKDigits402M {
    public static void main(String[] args) {
        String num = "1432219";
        int k = 3;
        System.out.print(removeKdigits(num, k));
    }

    public static String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();

        for (Character c : num.toCharArray()) {
            while (!stack.isEmpty() && stack.peek() > c && k > 0) {
                stack.pop();
                k--;
            }

            if (stack.isEmpty() && c == '0') {
                continue;
            }
            stack.push(c);
        }

        while (k>0&&!stack.isEmpty()) {
            stack.pop();
            k--;
        }

        if(stack.isEmpty()){
            return "0";
        }

        StringBuffer sb = new StringBuffer();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
