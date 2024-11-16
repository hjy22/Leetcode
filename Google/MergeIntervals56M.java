package Google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/merge-intervals/?envType=company&envId=google&favoriteSlug=google-thirty-  
public class MergeIntervals56M {
    public static void main(String[] args) {
        int[][] intervals = { { 1,4},{1,5} };
        int[][] ans = merge(intervals);
        for(int i=0;i<ans.length;i++){
            System.out.println(ans[i][0]+" "+ans[i][1]);

        }
    }

    public static int[][] merge(int[][] intervals) {
        List<int[]> list = new ArrayList<>();
        Arrays.sort(intervals,(a,b)->{
            return a[0]-b[0];
        });
        int start1=intervals[0][0];
        int end1 = intervals[0][1];
        for(int i=1;i<intervals.length;i++){
            int start2 = intervals[i][0];
            int end2=intervals[i][1];
            if(start2<=end1){
                end1 = Math.max(end1, end2);
            }else if(end1<start2){
                list.add(new int[]{start1,end1});
                start1 = start2;
                end1=end2;
            }
        }
        list.add(new int[]{start1,end1});
        return list.toArray(new int[list.size()][]);
    }
}
