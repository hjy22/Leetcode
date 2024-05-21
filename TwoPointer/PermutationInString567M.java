package TwoPointer;

import java.util.HashMap;
import java.util.Map;

public class PermutationInString567M {
    public static void main(String[] args) {
        String s = "ab";
        String t = "eidboaooo";
        System.out.println(checkInclusion(s, t));
    }

    public static boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        Map<Character, Integer> needs = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (char c : s1.toCharArray()) {
            needs.put(c, needs.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;
        int valid = 0;
        
        while (right < s2.length()) {
            char c = s2.charAt(right);
            right++;
            if (needs.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).intValue() == needs.get(c).intValue()) {
                    valid++;
                }
            }
            
            while (right - left >= s1.length()) {
                if (valid == needs.size()) {
                    return true;
                }
                char d = s2.charAt(left);
                left++;
                if (needs.containsKey(d)) {
                    if (window.get(d).intValue() == needs.get(d).intValue()) {
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }
        }
        
        return false;
    }
}
