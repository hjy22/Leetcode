package Tiktok;

import java.util.Stack;

// https://leetcode.com/problems/decode-string/?envType=company&envId=tiktok&favoriteSlug=tiktok-thirty-days
public class DecodeString394M {
    public static void main(String[] args) {
        String s = "3[a]2[bc]";
        System.out.println(decodeString(s));
    }

    public static String decodeString(String s) {
        Stack<Integer> numStack = new Stack<>();
        Stack<String> charStack = new Stack<>();
        String curString = "";
        int curNum = 0;
        
        for (Character c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                curNum = curNum*10+(c-'0');
            } else if (Character.isLetter(c)) {
                curString += c;
            } else if (c == '[') {
                numStack.push(curNum);
                charStack.push(curString);
                curNum = 0;
                curString ="";
            }else if(c==']'){
                int times = numStack.pop();
                String str = charStack.pop();
                while (times>0) {
                    str +=curString;
                    times--;
                }
                curString = str;
            }
        }
        return curString;
    }
}
