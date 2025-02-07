package Tiktok2025.SecondRound;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/longest-substring-without-repeating-characters/?envType=company&envId=tiktok&favoriteSlug=tiktok-three-months
public class LongestSubstringWithoutRepeatingCharacters3M {
    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0;
        int maxLength = 0;
        Map<Character, Integer> map = new HashMap<>();
        while (right < s.length()) {
            char c1 = s.charAt(right);
            map.put(c1, map.getOrDefault(c1, 0) + 1);
            while (map.get(c1) > 1) {
                char c2 = s.charAt(left);
                map.put(c2, map.get(c2) - 1);
                if (map.get(c2) == 0) {
                    map.remove(c2);
                }
                left++;
            }
            right++;
            maxLength = Math.max(maxLength, right - left);
        }
        return maxLength;
    }
}
