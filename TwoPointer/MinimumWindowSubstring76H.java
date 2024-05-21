package TwoPointer;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring76H {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minWindow(s, t));
    }

    public static String minWindow(String s, String t) {
        int left=0, right = 0;
        int start = 0, minLen = Integer.MAX_VALUE;
        Map<Character,Integer> needs = new HashMap<>();
        Map<Character,Integer> window = new HashMap<>();
        int valid=0;
        for (char c : t.toCharArray()) {
            needs.put(c, needs.getOrDefault(c, 0)+ 1);
        }
        while(right<s.length()){
            char c = s.charAt(right);
            if(needs.containsKey(c)){
                window.put(c, window.getOrDefault(c, 0)+ 1);
                if (window.get(c).intValue() == needs.get(c).intValue()) {
                    valid++;
                }
            }
            right++;
            while (valid == needs.size()) {
                if (right - left < minLen) {
                    start = left;
                    minLen = right - left;
                }
                char d = s.charAt(left);
                left++;
                if (needs.containsKey(d)) {
                    if (window.get(d).intValue() == needs.get(d).intValue()) {
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }
            
            
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}