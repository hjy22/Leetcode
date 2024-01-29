package String;

//https://leetcode.com/problems/reverse-prefix-of-word/
public class ReversePrefixofWord2000E {
    public static void main(String[] args) {
        String word = "abcd";
        char ch = 'z';
        System.out.println(reversePrefix(word, ch));
    }

    public static String reversePrefix(String word, char ch) {
        String ans = "";
        String reverse = "";
        int length = 0;
        while (length<word.length()) {
            char c = word.charAt(length);
            reverse += c;
            if (c == ch) {
                break;
            }
            length++;
        }
        for(int i=reverse.length()-1;i>=0;i--){
            ans+=reverse.charAt(i);
        }
        if(length==word.length()){
            return reverse;
        }
        ans+=word.substring(length+1, word.length());
        return ans;
    }
}
