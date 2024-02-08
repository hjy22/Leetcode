package TwoPointer;

//https://leetcode.com/problems/valid-palindrome-ii/
public class ValidPalindromeII680E {
    public static void main(String[] args) {
        String s = "aba";
        System.out.print(validPalindrome(s));
    }

    public static boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left <= right) {
            if (s.charAt(left) != s.charAt(right)) {
                if (isPalindrome(s, left + 1, right)) {
                    return true;
                }
                if (isPalindrome(s, left, right - 1)) {
                    return true;
                }
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static boolean isPalindrome(String s, int left, int right) {
        while (left <= right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
