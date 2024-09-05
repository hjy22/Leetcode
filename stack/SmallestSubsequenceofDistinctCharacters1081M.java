package Stack;

import java.util.Stack;

// https://leetcode.com/problems/smallest-subsequence-of-distinct-characters/
public class SmallestSubsequenceofDistinctCharacters1081M {
    public static void main(String[] args) {
        String s = "bcabc";
        System.out.println(smallestSubsequence(s));
    }

    public static String smallestSubsequence(String s) {
        int[] lastIndex = new int[26];
        boolean[] inStack = new boolean[26];
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }

        for (int i = 0; i < s.length(); i++) {
            Character c =s.charAt(i);
            if(inStack[c-'a']){
                continue;
            }
            while(!stack.isEmpty()&&stack.peek()>c&&lastIndex[stack.peek()-'a']>i){
                Character popChar = stack.pop();
                inStack[popChar-'a']=false;
            }
            stack.push(c);
            inStack[c-'a']=true;
        }
        
        StringBuilder str=new StringBuilder();
        while (!stack.isEmpty()) {
            str.append(stack.pop());
        }
        return str.reverse().toString();
    }
}
