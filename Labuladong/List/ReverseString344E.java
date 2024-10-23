package Labuladong.List;

// https://leetcode.com/problems/reverse-string/
public class ReverseString344E {
    public static void main(String[] args) {
        char[] s = { 'h', 'e', 'l', 'l', 'o' };
        reverseString(s);
        for (char c : s) {
            System.out.print(c + " ");

        }
    }

    public static void reverseString(char[] s) {
        int left=0,right = s.length-1;
        while (left<right) {
            char tmp = s[left];
            s[left] = s[right];
            s[right] = tmp;
            left++;
            right--;
        }
    }
}
