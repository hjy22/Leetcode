package Stack;

import java.util.Stack;

// https://leetcode.com/problems/remove-duplicate-letters/
public class RemoveDuplicateLetters316M {
    public static void main(String[] args) {
        String s = "bcabc";
        System.out.println(removeDuplicateLetters(s));
    }

    public static String removeDuplicateLetters(String s) {
        //先记录每一个char出现的最后位置
        int[] lastIndex = new int[26];
        boolean[] instack = new boolean[26];
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }

        for (int i = 0; i < s.length(); i++) {
            Character c =s.charAt(i);
            //判断是否在栈里
            if(instack[c-'a']){
                continue;
            }
            //当栈顶元素>当前元素，且不是lastIndex，弹出
            while(!stack.isEmpty()&&stack.peek()>c&&lastIndex[stack.peek()-'a']>i){
                Character popChar = stack.pop();
                instack[popChar-'a']=false;
            }
            stack.push(c);
            instack[c-'a']=true;
        }
        
        StringBuilder str=new StringBuilder();
        while (!stack.isEmpty()) {
            str.append(stack.pop());
        }
        return str.reverse().toString(); 
    }
}
