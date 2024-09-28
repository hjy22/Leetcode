package Top105;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

// https://leetcode.com/problems/merge-intervals/?envType=study-plan-v2&envId=top-interview-150
public class MergeIntervals56M {
    public static void main(String[] args) {
        int[][] intervals = { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };
        int[][] ans = merge(intervals);
    }

    public static int[][] merge(int[][] intervals) {
        List<int[]> ans = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> {
            return a[0] - b[0];
        });
        int left = intervals[0][0];
        int right = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= right) {
                right = Math.max(right, intervals[i][1]);
            } else {    
                ans.add(new int[]{left,right});
                left = intervals[i][0];
                right = intervals[i][1];
            }
        }
        ans.add(new int[]{left, right});
        return ans.toArray(new int[ans.size()][]);
    }
}
