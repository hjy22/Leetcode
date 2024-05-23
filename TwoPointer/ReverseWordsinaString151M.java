package TwoPointer;

//https://leetcode.com/problems/reverse-words-in-a-string/
public class ReverseWordsinaString151M {
    public static void main(String[] args) {
        String s = "  hello world  ";
        System.out.println(reverseWords(s));
    }

    public static String reverseWords(String s) {
        String ans ="";
        String[] list = s.trim().split("\\s+");
        for(int i=list.length-1;i>0;i--){
            ans+=list[i]+" ";
        }

        return ans+list[0];
    }
}
