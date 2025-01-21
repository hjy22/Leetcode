package Tiktok2025;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/permutation-in-string/
public class PermutationinString567M {
    public static void main(String[] args) {
        String s1 = "ab", s2 = "eidboaoo";
        System.out.println(checkInclusion(s1, s2));
    }

    public static boolean checkInclusion(String s1, String s2) {
        Map<Character,Integer> need = new HashMap<>();
        Map<Character,Integer> window = new HashMap<>();

        for(Character c:s1.toCharArray()){
            need.put(c, need.getOrDefault(c, 0)+1);
        }
        int left=0,right=0;
        int valid = 0;
        while (right<s2.length()) {
            char c1 = s2.charAt(right);
            if(need.containsKey(c1)){
                window.put(c1, window.getOrDefault(c1, 0)+1);
                if(window.get(c1).equals(need.get(c1))){
                    valid++;
                }
            }
            right++;
            while (right-left==s1.length()) {
                if(valid==need.size()){
                    return true;
                }
                char c2 = s2.charAt(left);
                if(need.containsKey(c2)){
                    if(window.get(c2).equals(need.get(c2))){
                        valid--;
                    }
                    window.put(c2, window.get(c2)-1);
                }
                left++;
            }
        }
        return false;
    }
}
