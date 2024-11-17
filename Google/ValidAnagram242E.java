package Google;

import java.util.Arrays;

// https://leetcode.com/problems/valid-anagram/?envType=company&envId=google&favoriteSlug=google-thirty-days
public class ValidAnagram242E {
    public static void main(String[] args) {
        String s = "anagram", t = "nagaram";
        System.out.println(isAnagram(s, t));
    }

    public static boolean isAnagram(String s, String t) {
        int[] encode1 = encode(s);
        int[] encode2 = encode(t);
        return Arrays.equals(encode1, encode2);
    }

    public static int[] encode(String s){
        int[] encode = new int[26];
        for(Character c: s.toCharArray()){
            encode[c-'a']++;
        }
        return encode;
    }
}
