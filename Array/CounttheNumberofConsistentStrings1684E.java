package Array;

import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/count-the-number-of-consistent-strings/
public class CounttheNumberofConsistentStrings1684E {
    public static void main(String[] args) {
        String allowed = "ab";
        String[] words = { "ad", "bd", "aaab", "baa", "badab" };
        System.out.println(countConsistentStrings(allowed, words));
    }

    public static int countConsistentStrings(String allowed, String[] words) {
        int ans = 0;
        Set<Character> set1 = new HashSet<>();

        for (Character c : allowed.toCharArray()) {
            set1.add(c);
        }
        for (String s : words) {
            Set<Character> set2 = new HashSet<>();
            for (Character c : s.toCharArray()) {
                set2.add(c);
            }
            if (set1.containsAll(set2)) {
                ans++;
            }
        }
        return ans;
    }
}
