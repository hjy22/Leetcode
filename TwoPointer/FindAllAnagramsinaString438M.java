package TwoPointer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://leetcode.com/problems/find-all-anagrams-in-a-string
public class FindAllAnagramsinaString438M {
    public static void main(String[] args) {
        String s = "cbaebabacd";
        String t = "abc";
        System.out.println(findAnagrams(s, t));
    }

    public static List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> needs = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        List<Integer> array = new ArrayList<>();
        for (char c : p.toCharArray()) {
            needs.put(c, needs.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;
        int valid = 0;
        
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            if (needs.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).intValue() == needs.get(c).intValue()) {
                    valid++;
                }
            }
            
            while (right - left >= p.length()) {
                if (valid == needs.size()) {
                    array.add(left);
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
        
        return array;
    }
}