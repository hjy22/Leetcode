package Top105;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/longest-consecutive-sequence/?envType=study-plan-v2&envId=top-interview-150
public class LongestConsecutiveSequence128M {
    public static void main(String[] args) {
        int[] nums = { 100, 4, 200, 1, 3, 2 };
        System.out.println(longestConsecutive(nums));
    }

    public static int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int maxLength = 0;

        for (int i : nums) {
            set.add(i);
        }
        for (int i : nums) {
            if (set.contains(i - 1)) {
                continue;
            }
            int length = 0;
            while (set.contains(i + 1)) {
                length++;
                i = i + 1;
            }
            maxLength = Math.max(maxLength, length+1);
        }
        return maxLength;
    }
}
