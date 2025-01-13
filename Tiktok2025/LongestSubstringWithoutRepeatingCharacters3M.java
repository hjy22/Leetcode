package Tiktok2025;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/longest-substring-without-repeating-characters/description/?envType=company&envId=tiktok&favoriteSlug=tiktok-three-months
public class LongestSubstringWithoutRepeatingCharacters3M {
    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0;
        int maxLen = 0;
        Map<Integer, Integer> map = new HashMap<>();
        while (right < s.length()) {
            int c = s.charAt(right);
            map.put(c, map.getOrDefault(c, 0) + 1);

            while (map.get(c) > 1) {
                int d = s.charAt(left);
                map.put(d, map.get(d) - 1);
                if (map.get(d) == 0) {
                    map.remove(d);
                }
                left++;
            }
            right++;
            maxLen = Math.max(maxLen, right - left);
        }
        return maxLen;
    }
}
