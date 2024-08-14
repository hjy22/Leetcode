package CoverRange;

import java.util.Arrays;

//https://leetcode.com/problems/remove-covered-intervals/
public class RemoveCoveredIntervals1288M {
    public static void main(String[] args) {
        int[][] intervals = { { 1, 2 }, { 1, 4 }, { 3, 4 } };
        System.out.println(removeCoveredIntervals(intervals));
    }

    public static int removeCoveredIntervals(int[][] intervals) {
        int ans = 0;
        // 按照起点升序排列，起点相同时降序排列
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] != b[0]) {
                return a[0]-b[0];
            } else {
                return b[1]- a[1];
            }
        });
        int left = intervals[0][0];
        int right = intervals[0][1];

        //ans存的是有多少个区间被前面的区间所覆盖
        for (int i = 1; i < intervals.length; i++) {
            if (left <= intervals[i][0] && right >= intervals[i][1]) {
                ans++;
            } else if (right >= intervals[i][0] && right <= intervals[i][1]) {
                right = intervals[i][1];
            } else if (right <= intervals[i][0]) {
                left = intervals[i][0];
                right = intervals[i][1];
            }
        }
        return intervals.length-ans;
    }
}
