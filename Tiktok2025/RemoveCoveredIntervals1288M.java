package Tiktok2025;

import java.util.Arrays;

// https://leetcode.com/problems/remove-covered-intervals/ 
public class RemoveCoveredIntervals1288M {
    public static void main(String[] args) {
        int[][] intervals = { { 1, 2 }, { 1, 4 }, { 3, 4 } };
        System.out.println(removeCoveredIntervals(intervals));
    }

    public static int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            } else {
                return b[1] - a[1];
            }
        });

        int preEnd = 0;
        int count = 0;

        for (int[] interval : intervals) {
            int curEnd = interval[1];

            if (curEnd > preEnd) {
                count++;
                preEnd = curEnd; 
            }
        }

        return count;
    }
}
