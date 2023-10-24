package array;

//https://leetcode.com/problems/longest-palindromic-substring/
public class LongestPalindromicSubstring5M {
    public static void main(String[] args) {
        String s = "bb";
        System.out.println(longestPalindrome(s));
    }

    public static String longestPalindrome(String s) {
        String ans = "";
        if(s.length()<2){
            return s;
        }
        for(int i=0;i<s.length();i++){
            for(int j=s.length();j>i;j--){
                String temp = s.substring(i, j);
                System.out.println(temp);
                if(checkPalindromic(temp)&&temp.length()>ans.length()){
                    ans = temp;
                }
            }
        }
        return ans;
    }

    public static boolean checkPalindromic(String s){
        int leftPointer = 0;
        int rightPointer = s.length()-1;
        while(leftPointer<=rightPointer){
            if(s.charAt(leftPointer++)!=s.charAt(rightPointer--)){
                return false;
            }
        }
        return true;
    }
}
