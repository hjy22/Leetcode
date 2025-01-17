package Tiktok2025;

import java.util.Stack;

// https://leetcode.com/problems/decode-string/submissions/1510810090/?envType=company&envId=tiktok&favoriteSlug=tiktok-three-months
public class DecodeString394M {
    public static void main(String[] args) {
        String s = "3[a]2[bc]";
        System.out.println(decodeString(s));
    }

    public static String decodeString(String s) {
        Stack<String> strStack = new Stack<>();
        Stack<Integer> intStack = new Stack<>();
        String curStr = "";
        String curInt = "";
        for (Character c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                curInt += c;
            } else if (Character.isLetter(c)) {
                curStr += c;
            } else if (c == '[') {
                intStack.push(Integer.valueOf(curInt));
                strStack.push(curStr);
                curInt = "";
                curStr = "";
            } else if (c == ']') {
                int times = intStack.pop();
                String str = strStack.pop();
                String tmp = "";
                for (int i = 0; i < times; i++) {
                    tmp += curStr;
                }
                curStr = str+tmp;
            }
        }
        return curStr;
    }
}
