package Tiktok2025;

// https://leetcode.com/problems/valid-palindrome-ii/submissions/1509719863/?envType=company&envId=tiktok&favoriteSlug=tiktok-three-months
public class ValidPalindromeII680E {
    public static void main(String[] args) {
        String s = "abc";
        System.out.println(validPalindrome(s));
    }

    public static boolean validPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                if(isPalindrome(s, left+1, right)){
                    return true;
                }
                if(isPalindrome(s, left, right-1)){
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
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
