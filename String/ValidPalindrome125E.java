package String;

//https://leetcode.com/problems/valid-palindrome/
public class ValidPalindrome125E {
    public static void main(String[] args) {
        String s = "0P";
        System.out.println(isPalindrome(s));
    }

    public static boolean isPalindrome(String s) {
        String str = "";
        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                if(Character.isUpperCase(c)){
                    c +=32;
                }
                str += c;
            }
        }
        // System.out.println(str);
        int left=0, right=str.length()-1;
        while(left<right){
            if(str.charAt(left)!=str.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
