package Tiktok2025;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/minimum-window-substring/
public class MinimumWindowSubstring76H {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC", t = "ABC";
        System.out.println(minWindow(s, t));
    }

    public static String minWindow(String s, String t) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;
        int valid = 0, start = 0, len = Integer.MAX_VALUE;
        while (right < s.length()) {
            char c1 = s.charAt(right);
            if (need.containsKey(c1)) {
                window.put(c1, window.getOrDefault(c1, 0) + 1);
                if (window.get(c1).equals(need.get(c1))) {
                    valid++;
                }
            }
            right++;

            while (valid == need.size()) {
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }
                char c2 = s.charAt(left);
                left++;
                if (need.containsKey(c2)) {
                    if (window.get(c2).equals(need.get(c2)) ) {
                        valid--;
                    }
                    window.put(c2, window.get(c2) - 1);
                }
            }
        }
        return len==Integer.MAX_VALUE?"":s.substring(start, start+len);
    }
}
