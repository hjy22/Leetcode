package Tiktok2025.Tiktok202504;

import java.util.Stack;

// https://leetcode.com/problems/decode-string/?envType=company&envId=tiktok&favoriteSlug=tiktok-thirty-days
public class DecodeString394M {
    public static void main(String[] args) {
        String s = "3[a]2[bc]";
        System.out.println(decodeString(s));
    }

    public static String decodeString(String s) {
        Stack<String> strStack = new Stack<>();
        Stack<String> numStack = new Stack<>();
        String curStr = "";
        String curNum = "";
        for (Character c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                curNum += c;
            } else if (Character.isLetter(c)) {
                curStr += c;
            } else if (c == '[') {
                strStack.push(curStr);
                numStack.push(curNum);
                curNum = "";
                curStr = "";
            } else if (c == ']') {
                int times = Integer.valueOf(numStack.pop());
                String preStr = strStack.pop();
                String str = "";
                while (times>0) {
                    str+=curStr;
                    times--;
                }
                curStr = preStr+str;
            }
        }
        return curStr;
    }
}
