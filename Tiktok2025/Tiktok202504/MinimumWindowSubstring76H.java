package Tiktok2025.Tiktok202504;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/minimum-window-substring/
public class MinimumWindowSubstring76H {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC", t = "ABC";
        System.out.println(minWindow(s, t));
    }

    public static String minWindow(String s, String t) {
        Map<Character, Integer> target = new HashMap<>();
        for (Character c : t.toCharArray()) {
            target.put(c, target.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> window = new HashMap<>();
        int left = 0, right = 0;
        int validNum = 0;
        int minLength = Integer.MAX_VALUE;
        int startIndex = 0;
        while (right < s.length()) {
            Character c = s.charAt(right);
            window.put(c, window.getOrDefault(c, 0) + 1);
            if (window.get(c).equals(target.get(c))) {
                validNum++;
            }
            right++;
            while (validNum == target.size()) {
                if (right - left < minLength) {
                    minLength = right - left;
                    startIndex = left;
                }
                Character d = s.charAt(left);
                if (window.get(d).equals(target.get(d))) {
                    validNum--;
                }
                window.put(d, window.get(d) - 1);
                left++;
            }

        }
        return minLength == Integer.MAX_VALUE ? "" : s.substring(startIndex, startIndex + minLength);
    }
}
