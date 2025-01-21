package Tiktok2025;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.com/problems/find-all-anagrams-in-a-string/
public class FindAllAnagramsinaString438M {
    public static void main(String[] args) {
        String s = "cbaebabacd", p = "abc";
        System.out.println(findAnagrams(s, p));
    }

    public static List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        for (Character c : p.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        int left = 0, right = 0;
        int valid = 0;
        List<Integer> list = new ArrayList<>();
        while (right < s.length()) {
            char c1 = s.charAt(right);
            if (need.containsKey(c1)) {
                window.put(c1, window.getOrDefault(c1, 0) + 1);
                if (window.get(c1).equals(need.get(c1))) {
                    valid++;
                }
            }
            right++;
            while (right - left >= p.length()) {
                if (valid == need.size()) {
                    list.add(left);

                }
                char c2 = s.charAt(left);
                if (need.containsKey(c2)) {
                    if (window.get(c2).equals(need.get(c2))) {
                        valid--;
                    }
                    window.put(c2, window.get(c2) - 1);
                }
                left++;
            }
        }
        return list;
    }
}
