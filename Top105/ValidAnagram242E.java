package Top105;

import java.util.Arrays;

// https://leetcode.com/problems/valid-anagram/?envType=study-plan-v2&envId=top-interview-150
public class ValidAnagram242E {
    public static void main(String[] args) {
        String s = "anagram", t = "nagaram";
        System.out.print(isAnagram(s, t));
    }

    public static boolean isAnagram(String s, String t) {
        int[] num1 = encode(s);
        int[] num2 = encode(t);
        return Arrays.equals(num1, num2);
    }

    public static int[] encode(String str) {
        int[] num = new int[26];
        for (Character c : str.toCharArray()) {
            num[c - 'a']++;
        }
        return num;
    }

}
