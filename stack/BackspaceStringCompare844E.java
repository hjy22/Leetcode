package Stack;

import java.util.Stack;

//https://leetcode.com/problems/backspace-string-compare/
public class BackspaceStringCompare844E {
    public static void main(String[] args) {
        String s = "y#fo##f";
        String t = "y#f#o##f";
        System.out.println(backspaceCompare(s,t));
    }

    public static boolean backspaceCompare(String s, String t) {
        String str1=getSrting(s);
        String str2=getSrting(t);
        System.out.println(str1+" "+str2);
        return str1.equals(str2);
    }

    public static String getSrting(String s){
        Stack<Character> stack = new Stack<>();
        String ans = "";
        for(Character c:s.toCharArray()){
            if(c=='#'&&!stack.empty()){
                stack.pop();
            }else if(c!='#'){
                stack.push(c);
            }
        }
        while(!stack.isEmpty()){
            ans+=stack.pop();
        }
        return ans;
    }
}
