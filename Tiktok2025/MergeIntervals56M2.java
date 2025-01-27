package Tiktok2025;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals56M2 {
    public static void main(String[] args) {
        int[][] intervals = { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };
        System.out.println(merge(intervals));
    }


    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            return a[0] - b[0];
        });
        List<int[]> list = new ArrayList<>();
        int preStart = intervals[0][0];
        int preEnd = intervals[0][1];
        for (int i=1;i<intervals.length;i++) {
            int curStart = intervals[i][0];
            int curEnd = intervals[i][1];
            if(curStart<=preEnd&&curEnd>=preEnd){
                preEnd = Math.max(preEnd, curEnd);
            }else if(curStart>preEnd){
                list.add(new int[]{preStart,preEnd});
                preEnd = curEnd;
                preStart = curStart;
            }
        }
        list.add(new int[]{preStart,preEnd});
        int[][] ans = new int[list.size()][2];
        int index=0;
        for(int[] item:list){
            ans[index] = item;
            index++;
        }
        return ans;
    }
}
