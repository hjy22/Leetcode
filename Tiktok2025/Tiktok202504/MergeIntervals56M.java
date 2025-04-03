package Tiktok2025.Tiktok202504;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/merge-intervals/description/?envType=company&envId=tiktok&favoriteSlug=tiktok-three-months
public class MergeIntervals56M {
    public static void main(String[] args) {
        int[][] intervals = { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };
        System.out.println(merge(intervals));
    }

    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            return a[0] - b[0];
        });

        List<int[]> ans = new ArrayList<>();
        int preStart = intervals[0][0], preEnd = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            int curStart = intervals[i][0], curEnd = intervals[i][1]; 
            if(curStart<=preEnd){
                preEnd = Math.max(curEnd,preEnd);
            }else if(curStart>preEnd){
                ans.add(new int[]{preStart,preEnd});
                preEnd = curEnd;
                preStart = curStart;
            }
        }
        ans.add(new int[]{preStart,preEnd});
        return ans.toArray(new int[ans.size()][]);
    }
}
