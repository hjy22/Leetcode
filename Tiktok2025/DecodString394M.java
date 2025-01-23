package Tiktok2025;

import java.util.Stack;

// https://leetcode.com/problems/decode-string/
public class DecodString394M {
    public static void main(String[] args) {
        String s = "3[a]2[bc]";
        System.out.println(decodeString(s));
    }

    public static String decodeString(String s) {
        Stack<String> strStack = new Stack<>();
        Stack<String> intStack = new Stack<>();
        String curStr = "";
        String curInt = "";
        for (Character c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                curInt += c;
            } else if (Character.isLetter(c)) {
                curStr += c;
            } else if (c == '[') {
                strStack.push(curStr);
                intStack.push(curInt);
                curInt = "";
                curStr = "";
            } else if (c == ']') {
                int times = Integer.valueOf(intStack.pop());
                String str = strStack.pop();
                String tmp ="";
                while (times>0) {
                    tmp+=curStr;
                    times--;
                }
                curStr=str+tmp;
            }
        }
        return curStr;
    }
}
