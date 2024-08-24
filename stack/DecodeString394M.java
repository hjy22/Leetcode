package Stack;

import java.util.Stack;

//https://leetcode.com/problems/decode-string/
public class DecodeString394M {
    public static void main(String[] args) {
        String s = "3[a]2[bc]";
        System.out.println(decodeString(s));
    }

    // 两个stack，一个存数字，一个存字母
    // 遇到]就弹出字母和数字
    public static String decodeString(String s) {
        Stack<Integer> numStack = new Stack<>();
        Stack<String> stringStack = new Stack<>();
        String currentString = "";
        int num = 0;

        for (Character c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            } else if (Character.isLetter(c)) {
                currentString += c;
            } else if (c == '[') {
                numStack.push(num);
                stringStack.push(currentString);
                currentString = "";
                num = 0;
            } else if (c == ']') {
                String decodedString = stringStack.pop();
                int currentNum = numStack.pop();
                for (int i = 0; i < currentNum; i++) {
                    decodedString += currentString;
                }
                currentString = decodedString;
            }
        }
        return currentString;
    }
}
