package Array;

import java.util.Arrays;

//https://leetcode.com/problems/valid-anagram/description/
public class ValidAnagram242E {
    public static void main(String[] args) {
        String s = "anagram", t = "nagaram";
        System.out.println(isAnagram(s, t));

    }

    public static boolean isAnagram(String s, String t) {
        int[] str1 = encode(s);
        int[] str2 = encode(t);
        return Arrays.equals(str1, str2);
    }

    public static int[] encode(String str) {
        int[] charArray = new int[26];
        for (char c : str.toCharArray()) {
            int index = c - 'a';
            charArray[index]++;
        }
        return charArray;
    }
}
