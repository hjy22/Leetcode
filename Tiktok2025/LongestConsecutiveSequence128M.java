package Tiktok2025;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/longest-consecutive-sequence/?envType=company&envId=tiktok&favoriteSlug=tiktok-three-months
public class LongestConsecutiveSequence128M {
    public static void main(String[] args) {
        int[] nums = { 100, 4, 200, 1, 3, 2 };
        System.out.println(longestConsecutive(nums));
    }

    public static int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            set.add(i);
        }

        int maxLen = 0;
        for (int i : set) {
            if (set.contains(i - 1)) {
                continue;
            }
            int length = 0;
            int num = i;
            while (set.contains(num)) {
                length++;
                num++;
            }
            maxLen = Math.max(maxLen, length);
        }
        return maxLen;
    }
}
