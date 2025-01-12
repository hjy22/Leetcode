package Tiktok2025;

import java.util.ArrayList;
import java.util.Arrays;

// https://leetcode.com/problems/merge-intervals/?envType=company&envId=tiktok&favoriteSlug=tiktok-thirty-days
public class MergeIntervals56M {
    public static void main(String[] args) {
        // int[][] intervals = { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };
        int[][] intervals = { { 1, 4 }, { 1, 5 } };
        int[][] ans = merge(intervals);
        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i][0] + " " + ans[i][1]);
        }
    }

    public static int[][] merge(int[][] intervals) {
        ArrayList<int[]> arr = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> {
            return a[0] - b[0];
        });

        int preStart = intervals[0][0];
        int preEnd = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            int curStart = intervals[i][0];
            int curEnd = intervals[i][1];
            if (curStart >= preStart && curStart <= preEnd) {
                preEnd = Math.max(preEnd, curEnd);
            } else if (curStart > preEnd) {
                arr.add(new int[] { preStart, preEnd });
                preStart = curStart;
                preEnd = curEnd;
            }
        }

        arr.add(new int[] { preStart, preEnd });
        return arr.toArray(new int[arr.size()][]);
    }
}
