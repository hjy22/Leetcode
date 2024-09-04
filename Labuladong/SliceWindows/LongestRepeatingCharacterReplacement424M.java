package Labuladong.SliceWindows;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/longest-repeating-character-replacement/
public class LongestRepeatingCharacterReplacement424M {
    public static void main(String[] args) {
        String s = "ABAB";
        int k = 2;
        System.out.println(characterReplacement(s, k));
    }

    public static int characterReplacement(String s, int k) {
        int left=0,right=0;
        int maxLen=0,maxFreq=0;
        int[] count = new int[26];
        while (right<s.length()) {
            Character c = s.charAt(right);
            count[c-'A']++;
            maxFreq = Math.max(count[c-'A'], maxFreq);
            right++;
            while (maxFreq+k<right-left) {
                Character d = s.charAt(left);
                count[d-'A']--;
                left++;
            }
            
            maxLen = Math.max(maxLen, right-left);
        }
        return maxLen;
    }
}
