package Tiktok;

import java.util.AbstractMap;
import java.util.Map;
import java.util.Stack;

import Stack.Pair;


public class RemoveAllAdjacentDuplicatesinStringII1209M {
    public static void main(String[] args) {
        String s = "yfttttfbbbbnnnnffbgffffgbbbbgssssgthyyyy";
        int k = 4;
        System.out.println(removeDuplicates(s, k));
    }

    public static String removeDuplicates(String s, int k) {
        Stack<Character> charStack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();
        for(Character c:s.toCharArray()){
            if(!numStack.isEmpty()&&!charStack.isEmpty()&&charStack.peek()==c){
                charStack.push(c);
                numStack.push(numStack.pop()+1);
            }else{
                charStack.push(c);
                numStack.push(1);
            }

            if(numStack.peek()==k){
                int times = numStack.pop();
                while (times>0) {
                    charStack.pop();
                    times--;
                }
            }
        }
        StringBuffer sb = new StringBuffer();
        while (!charStack.isEmpty()) {
            sb.append(charStack.pop());
        }
        return sb.reverse().toString();
    }
}
