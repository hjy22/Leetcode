package Tiktok;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/longest-substring-without-repeating-characters/?envType=company&envId=tiktok&favoriteSlug=tiktok-thirty-days
public class LongestSubstringWithoutRepeatingCharacters3M {
    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0;
        int maxLength = Integer.MIN_VALUE;
        Map<Character, Integer> map = new HashMap<>();
        while (right < s.length()) {
            Character c = s.charAt(right);
            map.put(c, map.getOrDefault(c, 0) + 1);
            right++;
            while (map.get(c) > 1) {
                Character d = s.charAt(left);
                map.put(d, map.get(d) - 1);
                if (map.get(d) == 0) {
                    map.remove(d);
                }
                left++;
            }
            maxLength = Math.max(maxLength, right - left);
        }
        return maxLength == Integer.MIN_VALUE ? 0 : maxLength;
    }
}
