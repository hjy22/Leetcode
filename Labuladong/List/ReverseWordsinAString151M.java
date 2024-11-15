package Labuladong.List;

// https://leetcode.com/problems/reverse-words-in-a-string/
public class ReverseWordsinAString151M {
    public static void main(String[] args) {
        String s = "the sky is blue";
        System.out.println(reverseWords(s));
    }

    public static String reverseWords(String s) {
        String[] strs = s.trim().split("\\s+");
        String ans = "";
        for(int i=strs.length-1;i>0;i--){
            ans+=strs[i]+" ";
        }
        return ans+strs[0];
    }
}
