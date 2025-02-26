package RoundOne2025;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
public class LongestSubstringWithoutRepeatingCharacters3M {
    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> window = new HashMap<>();
        int left = 0,right=0;
        int maxLength = Integer.MIN_VALUE;
        while (right<s.length()) {
            char c = s.charAt(right);
            window.put(c, window.getOrDefault(c, 0)+1);
            right++;

            while (window.get(c)>1) {
                char d = s.charAt(left);
                window.put(d, window.get(d)-1);
                if(window.get(d)==0){
                    window.remove(d);
                }
                left++;
            }
            maxLength = Math.max(maxLength, right-left);
        }
        return maxLength==Integer.MIN_VALUE?0:maxLength;
    }
}
