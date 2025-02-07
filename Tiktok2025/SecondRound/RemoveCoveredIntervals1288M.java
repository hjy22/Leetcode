package Tiktok2025.SecondRound;

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

        int preEnd = intervals[0][1];
        int count = 0;
        for(int i=1;i<intervals.length;i++){
            int curEnd = intervals[i][1];
            if(curEnd<preEnd){
                count++;
            }else{
                preEnd=curEnd;
            }
        }
        return intervals.length-count;
    }
}
