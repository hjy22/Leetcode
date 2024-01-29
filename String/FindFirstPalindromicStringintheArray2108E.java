package String;

//https://leetcode.com/problems/find-first-palindromic-string-in-the-array/ 
public class FindFirstPalindromicStringintheArray2108E {
    public static void main(String[] args) {
        String[] words = { "abc", "car", "ada", "racecar", "cool" };
        System.out.println(firstPalindrome(words));
    }

    public static String firstPalindrome(String[] words) {
        String ans="";
        for(String str:words){
            if(check(str)){
                return str;
            }
        }
        return ans;
    }

    public static boolean check(String str) {
        int start = 0;
        int end=str.length()-1;
        while(start<=end){
            if(str.charAt(start)!=str.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
