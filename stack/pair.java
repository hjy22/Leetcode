package stack;

import java.util.Stack;

public class pair {
    public static void main(String[] args) {
        String s = "[[[]]]{{{}}}((())))";
        System.out.println(isBalanced(s));
    }

    static boolean isBalanced(String s){
    if(s.length()==0){
        return true;
    }
    Stack<Character> stack = new Stack();
    char[] array = s.toCharArray();
    for(Character c:array){
        if(stack.isEmpty()){
            return false;
        }
        if(c=='('||c=='{'||c=='['){
            stack.push(c);
        }else if(c==')'&&stack.peek()=='('){
            stack.pop();
        }else if(c=='}'&&stack.peek()=='{'){
            stack.pop();
        }else if(c==']'&&stack.peek()=='['){
            stack.pop();
        }
    }
    return stack.isEmpty();
}
