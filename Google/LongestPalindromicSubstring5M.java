package Google;

// https://leetcode.com/problems/longest-palindromic-substring/?envType=company&envId=google&favoriteSlug=google-thirty-days
public class LongestPalindromicSubstring5M {
    public static void main(String[] args) {
        String s = "babad";
        System.out.println(longestPalindrome(s));
    }

    public static String longestPalindrome(String s) {
        String ans ="";
        for(int i=0;i<s.length();i++){
            String str1=isPalindrome(s, i, i);
            String str2=isPalindrome(s, i, i+1);
            ans = ans.length()>str1.length()?ans:str1;
            ans = ans.length()>str2.length()?ans:str2;
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
