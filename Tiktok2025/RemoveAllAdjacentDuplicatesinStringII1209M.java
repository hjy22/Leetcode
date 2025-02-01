package Tiktok2025;

import java.util.Stack;

// https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/?envType=company&envId=tiktok&favoriteSlug=tiktok-six-months
public class RemoveAllAdjacentDuplicatesinStringII1209M {
    public static void main(String[] args) {
        String s = "deeedbbcccbdaa";
        int k = 3;
        System.out.println(removeDuplicates(s, k));
    }

    public static String removeDuplicates(String s, int k) {
        Stack<Character> charStack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();
        for (Character c : s.toCharArray()) {
            if (!charStack.isEmpty() && !numStack.isEmpty() && charStack.peek() == c) {
                charStack.push(c);
                numStack.push(numStack.pop() + 1);
            } else {
                charStack.push(c);
                numStack.push(1);
            }
            if (numStack.peek() == k) {
                int times = numStack.pop();
                while (times > 0) {
                    charStack.pop();
                    times--;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!charStack.isEmpty()) {
            sb.append(charStack.pop());
        }
        return sb.reverse().toString();
    }
}
