package Stack;

import java.util.Stack;

//https://leetcode.com/problems/valid-parentheses/
public class ValidParenthesesE20 {
    public static void main(String[] args) {
        String s = "()";
        System.out.print(isValid(s));
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(Character c:s.toCharArray()){
            if(c=='('|c=='['||c=='{'){
                stack.push(c);
            }else if(c==')'&&stack.peek()=='('){
                stack.pop();
            }else if(c==']'&&stack.peek()=='['){
                stack.pop();
            }else if(c=='}'&&stack.peek()=='{'){
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
