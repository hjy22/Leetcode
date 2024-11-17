package Google;

import java.util.Stack;

// https://leetcode.com/problems/decode-string/?envType=company&envId=google&favoriteSlug=google-thirty-days
public class DecodeString394M {
    public static void main(String[] args) {
        String s = "3[a]2[bc]";
        System.out.println(decodeString(s));
    }

    public static String decodeString(String s) {
        Stack<String> charStack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();
        String saveString = "";
        String saveNum = "";
        for (Character c : s.toCharArray()) {
            if (Character.isAlphabetic(c)) {
                saveString += c;
            } else if (Character.isDigit(c)) {
                saveNum += c;
            } else if (c == '[') {
                charStack.push(saveString);
                numStack.push(Integer.valueOf(saveNum));
                saveString = "";
                saveNum = "";
            } else if (c == ']') {
                int times = numStack.pop();
                String str = charStack.pop();
                while (times > 0) {
                    str += saveString;
                    times--;
                }
                saveString = str;
            }
        }

        return saveString;
    }
}
