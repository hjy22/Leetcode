package Top105;

// https://leetcode.com/problems/reverse-words-in-a-string/description/?envType=study-plan-v2&envId=top-interview-150
public class ReverseWordsinaString151M {
    public static void main(String[] args) {
        String s = "the sky is blue";
        System.out.println(reverseWords(s));
    }

    public static String reverseWords(String s) {
        String[] arr = s.trim().split("\\s+");
        String ans = "";
        for (int i = arr.length - 1; i > 0; i--) {
            ans += arr[i] + " ";
        }

        return ans + arr[0];
    }
}
