package Tiktok2025.SecondRound;

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
        Map<Character, Integer> windows = new HashMap<>();
        for (Character c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;
        int valid = 0,minLen = Integer.MAX_VALUE;
        int startIndex=  0;
        while (right < s.length()) {
            char c1 = s.charAt(right);
            if(need.containsKey(c1)){
                windows.put(c1, windows.getOrDefault(c1, 0)+1);

                if(windows.get(c1).equals(need.get(c1))){
                    valid++;
                }
            }

            right++;
            while (need.size()==valid) {
                if(right-left<minLen){
                    startIndex = left;
                    minLen = right-left;
                }
                char c2=s.charAt(left);
                if(need.containsKey(c2)){
                    if(windows.get(c2).equals(need.get(c2))){
                        valid--;
                    }
                    windows.put(c2, windows.get(c2)-1);
                }
                left++;
               
            }
        }
        System.out.println(startIndex+" "+minLen);
        return minLen==Integer.MAX_VALUE?"":s.substring(startIndex, startIndex+minLen);
    }
}
