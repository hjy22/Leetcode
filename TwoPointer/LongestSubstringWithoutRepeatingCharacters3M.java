package TwoPointer;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters3M {
    public static void main(String[] args) {
        String s = "bbbb";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> window = new HashMap<>();

        int left = 0, right = 0;
        int valid = 0;
        int maxLen =0;
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            window.put(c, window.getOrDefault(c, 0) + 1);
            valid++;
            
            while (window.get(c)>1) {
                char d = s.charAt(left);
                left++;
                if (window.containsKey(d)) {
                    valid--;
                    window.put(d, window.get(d) - 1);
                }
            }
            maxLen = Math.max(maxLen, right-left);
        }
        
        return maxLen;
    }   
}
