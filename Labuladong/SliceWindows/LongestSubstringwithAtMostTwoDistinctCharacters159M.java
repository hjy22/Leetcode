package Labuladong.SliceWindows;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/longest-substring-with-at-most-two-distinct-characters/
public class LongestSubstringwithAtMostTwoDistinctCharacters159M {
    public static void main(String[] args) {
        String s = "eceba";
        System.out.println(lengthOfLongestSubstringTwoDistinct(s));
    }

    public static int lengthOfLongestSubstringTwoDistinct(String s) {
        int maxLen = 0;
        Map<Character, Integer> map = new HashMap<>();
        int left = 0, right = 0;
        while (right < s.length()) {
            Character c = s.charAt(right);
            map.put(c, map.getOrDefault(c, 0) + 1);

            while (map.size() > 2) {
                Character d = s.charAt(left);
                map.put(d, map.get(d) - 1);
                if (map.get(d) == 0) {
                    map.remove(d);
                }
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }
        return maxLen;
    }
}
