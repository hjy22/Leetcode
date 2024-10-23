package Labuladong.List;

public class LongestPalindromicSubstring5M {
    public static void main(String[] args) {
        String s = "babad";
        System.out.println(longestPalindrome(s));
    }

    public static String longestPalindrome(String s) {
        String ans = "";
        for(int i=0;i<s.length();i++){
            String str1 = findLongest(s, i, i);
            String str2= findLongest(s, i, i+1);
            ans = str1.length()>ans.length()?str1:ans;
            ans = str2.length()>ans.length()?str2:ans;
        }
        return ans;
    }

    public static String findLongest(String s,int i,int j){
        while (i>=0&&j<s.length()) {
            if(s.charAt(i)!=s.charAt(j)){
                break;
            }
            i--;
            j++;
        }
        return s.substring(i+1, j);
    }
}
