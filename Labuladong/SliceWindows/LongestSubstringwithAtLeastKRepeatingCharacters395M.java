package Labuladong.SliceWindows;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/description
public class LongestSubstringwithAtLeastKRepeatingCharacters395M {
    public static void main(String[] args) {
        String s = "aaabb";
        int k = 3;
        System.out.println(longestSubstring(s, k));
    }

    public static int longestSubstring(String s, int k) {
        int maxLen = 0;
        for (int i = 1; i <= 26; i++) {
            maxLen = Math.max(maxLen, logestKLetterSubstr(s, k, i));
        }
        return maxLen;
    }

    // 寻找 s 中含有 count 种字符，且每种字符出现次数都不少于 k 的最长子串
    public static int logestKLetterSubstr(String s, int k, int count) {
        int left = 0, right = 0;
        int[] validChar = new int[26];
        int validCount = 0;
        int uniqueCount=0;
        int maxLenth = 0;
        while(right<s.length()){
            char c = s.charAt(right);
            if(validChar[c-'a']==0){
                uniqueCount++;
            }
            validChar[c-'a']++;
            if(validChar[c-'a']==k){
                validCount++;
            }
            right++;
            while(uniqueCount>count){
                char d = s.charAt(left);
                if(validChar[d-'a']==k){
                    validCount--;
                }
                validChar[d-'a']--;
                if(validChar[d-'a']==0){
                    uniqueCount--;
                }
                left++;
            }
            if (uniqueCount == count && validCount == uniqueCount) {
                maxLenth = Math.max(maxLenth, right - left);
            }
        }
        return maxLenth;
    }
}
