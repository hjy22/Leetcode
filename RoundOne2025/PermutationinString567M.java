package RoundOne2025;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/permutation-in-string/?show=1
public class PermutationinString567M {
    public static void main(String[] args) {
        String s1 = "ab", s2 = "eidbaooo";
        System.out.println(checkInclusion(s1, s2));
    }

    public static boolean checkInclusion(String s1, String s2) {
        Map<Character,Integer> need = new HashMap<>();
        Map<Character,Integer> window = new HashMap<>();

        for(Character c:s1.toCharArray()){
            need.put(c, need.getOrDefault(c, 0)+1);
        }

        int left = 0,right=0;
        int valid =0;
        while (right<s2.length()) {
            char c = s2.charAt(right);
            if(need.containsKey(c)){
                window.put(c, window.getOrDefault(c, 0)+1);

                if(window.get(c).equals(need.get(c))){
                    valid++;
                }
            }
            right++;
            while (right - left == s1.length()) {
                if(valid==need.size()){
                    return true;
                }
                char d = s2.charAt(left);
                if(need.containsKey(d)){
                    if(need.get(d).equals(window.get(d))){
                        valid--;
                    }
                    window.put(d, window.get(d)-1);
                }
                left++;
            }
        }
        return false;
    }
}
