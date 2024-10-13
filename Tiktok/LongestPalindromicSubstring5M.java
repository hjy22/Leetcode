package Tiktok;

// https://leetcode.com/problems/longest-palindromic-substring/description/?envType=company&envId=tiktok&favoriteSlug=tiktok-thirty-days
public class LongestPalindromicSubstring5M {
    public static void main(String[] args) {
        String s = "babad";
        System.out.println(longestPalindrome(s));
    }

    public static String longestPalindrome(String s) {
        String ans = "";
        for(int i=0;i<s.length();i++){
            String str1 = getPalindrome(i, i, s);
            String str2 = getPalindrome(i, i+1, s);
            ans = ans.length()>str1.length()?ans:str1;
            ans = ans.length()>str2.length()?ans:str2;
        }
        return ans;
    }

    public static String getPalindrome(int i,int j,String s){
        while (i>=0&&j<s.length()) {
            if(s.charAt(i)!=s.charAt(j)){
                break;
            }
            j++;
            i--;
        }
        return s.substring(i+1, j);
    }
}
