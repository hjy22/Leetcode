package Array;

import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/longest-substring-without-repeating-characters/
public class LongestSubstring3M {
    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        int length = Integer.MAX_VALUE;
        for(int i=0;i<s.length();i++){
            int temp = getLength(s.substring(i, s.length()-1));
            length = Math.max(length, temp);
        }
        return length;
    }

    public static int getLength(String s) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (!set.contains(s.charAt(i))) {
                set.add(s.charAt(i));
            } else {
                return i;
            }
        }
        return Integer.MAX_VALUE;
    }
}
