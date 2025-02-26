package RoundOne2025;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/minimum-window-substring/description/?show=1
public class MinimumWindowSubstring76H {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC", t = "ABC";
        System.out.println(minWindow(s, t));
    }

    public static String minWindow(String s, String t) {
            Map<Character, Integer> need = new HashMap<>();
            Map<Character, Integer> window = new HashMap<>();

            for (Character c : t.toCharArray()) {
                need.put(c, need.getOrDefault(c, 0) + 1);
            }

            int left=0,right=0;
            int valid=0;
            int minLength = Integer.MAX_VALUE;
            int startIndex = 0;
            while (right<s.length()) {
                char c = s.charAt(right);
                if(need.containsKey(c)){
                    window.put(c, window.getOrDefault(c, 0)+1);
                    if(window.get(c).equals(need.get(c))){
                        valid++;
                    }
                }
                right++;

                while(valid==need.size()){
                    if(minLength>right-left){
                        startIndex = left;
                        minLength = right-left;
                    }
                    char d = s.charAt(left);
                    if(need.containsKey(d)){
                        if(window.get(d).equals(need.get(d))){
                            valid--;
                        }
                        window.put(d, window.get(d)-1);
                    }
                    left++;
                }
            }
            return minLength==Integer.MAX_VALUE?"":s.substring(startIndex, startIndex+minLength);
    }
}
