package TwoPointer;

//https://leetcode.com/problems/lexicographically-smallest-palindrome/
public class LexicographicallySmallestPalindromeE2697 {
    public static void main(String[] args) {
        String s = "egcfe";
        System.out.println(makeSmallestPalindrome(s));
    }

    public static String makeSmallestPalindrome(String s) {
        char[] charArray = new char[s.length()];
        int start = 0;
        int end = s.length() - 1;
        while (start <= end) {
            char first = s.charAt(start);
            char second = s.charAt(end);
            if (first < second) {
                charArray[start] = first;
                charArray[end] = first;
            } else {
                charArray[start] = second;
                charArray[end] = second;
            }
            start++;
            end--;
        }
        return new String(charArray);
    }
}
