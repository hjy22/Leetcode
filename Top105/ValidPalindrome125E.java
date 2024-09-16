package Top105;

// https://leetcode.com/problems/valid-palindrome/description/?envType=study-plan-v2&envId=top-interview-150
public class ValidPalindrome125E {
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(s));
    }

    public static boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        s=s.toLowerCase();
        System.out.println(s);
        while (left < right) {
            if (!Character.isLetterOrDigit(s.charAt(left))) {
                left++;
                continue;
            }
            if (!Character.isLetterOrDigit(s.charAt(right))) {
                right--;
                continue;
            }
            if(s.charAt(left)!=s.charAt(right)){
                System.out.println(left+" "+right);
                System.out.println(s.charAt(left)+" "+s.charAt(right));
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
