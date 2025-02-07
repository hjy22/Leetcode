package Tiktok2025.SecondRound;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/merge-intervals/?envType=company&envId=tiktok&favoriteSlug=tiktok-thirty-days
public class MergeIntervals56M {
    public static void main(String[] args) {
        int[][] intervals = { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };
        // int[][] intervals = { { 1, 4 }, { 1, 5 } };
        int[][] ans = merge(intervals);
        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i][0] + " " + ans[i][1]);
        }
    }

    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            return a[0] - b[0];
        });

        List<int[]> list = new ArrayList<>();
        int preStart = intervals[0][0], preEnd = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            int curStart = intervals[i][0], curEnd = intervals[i][1];
            if(preEnd>=curStart){
                preEnd = Math.max(curEnd, preEnd);
            }else if (curStart>preEnd){
                list.add(new int[]{preStart,preEnd});
                preStart = curStart;
                preEnd = curEnd;
            }
        }
        list.add(new int[]{preStart,preEnd});
        return list.toArray(new int[list.size()][]);
    }
}
