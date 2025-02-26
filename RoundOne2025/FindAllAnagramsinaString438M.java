package RoundOne2025;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.com/problems/find-all-anagrams-in-a-string/?show=1
public class FindAllAnagramsinaString438M {
    public static void main(String[] args) {
        String s = "cbaebabacd", p = "abc";
        System.out.println(findAnagrams(s, p));
    }

    public static List<Integer> findAnagrams(String s, String p) {
        Map<Character,Integer> need = new HashMap<>();
        Map<Character,Integer> window = new HashMap<>();
        for(Character c:p.toCharArray()){
            need.put(c, need.getOrDefault(c, 0)+1);
        }

        List<Integer> startList = new ArrayList<>();

        int left = 0,right=0;
        int valid = 0;
        while (right<s.length()) {
            char c = s.charAt(right);
            if(need.containsKey(c)){
                window.put(c, window.getOrDefault(c, 0)+1);
                if(window.get(c).equals(need.get(c))){
                    valid++;
                }
            }
            right++;
            while (right-left==p.length()) {
                if(valid ==need.size()){
                    startList.add(left);
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
        return startList;
    }
}
