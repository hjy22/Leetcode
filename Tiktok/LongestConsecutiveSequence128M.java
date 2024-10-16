package Tiktok;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/longest-consecutive-sequence/?envType=company&envId=tiktok&favoriteSlug=tiktok-thirty-days
public class LongestConsecutiveSequence128M {
    public static void main(String[] args) {
        int[] nums = { 100, 4, 200, 1, 3, 2 };
        System.out.println(longestConsecutive(nums));
    }

    public static int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (Integer i : nums) {
            set.add(i);
        }
        int maxLen = 0;
        for (int i : nums) {
            if (set.contains(i - 1)) {
                continue;
            }
            int length = 0;
            while (set.contains(i + 1)) {
                length++;
                i++;
            }
            maxLen = Math.max(length+1, maxLen);
        }
        return maxLen;
    }
}
