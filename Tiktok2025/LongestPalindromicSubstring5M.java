package Tiktok2025;

// https://leetcode.com/problems/longest-palindromic-substring/?envType=company&envId=tiktok&favoriteSlug=tiktok-three-months
public class LongestPalindromicSubstring5M {
    public static void main(String[] args) {
        String s = "babad";
        System.out.println(longestPalindrome(s));
    }

    public static String longestPalindrome(String s) {
        String ans = "";
        for (int i = 0; i < s.length(); i++) {
            String s1 = isPalindrome(s, i, i);
            String s2 = isPalindrome(s, i, i + 1);
            ans = s1.length() > ans.length() ? s1 : ans;
            ans = s2.length() > ans.length() ? s2 : ans;
        }
        return ans;
    }

    public static String isPalindrome(String s, int left, int right) {
        while (left >= 0 && right < s.length()) {
            if (s.charAt(left) != s.charAt(right)) {
                break;
            }
            left--;
            right++;
        }
        return s.substring(left+1, right);
    }
}
