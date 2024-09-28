package Top105;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/insert-interval/?envType=study-plan-v2&envId=top-interview-150
public class InsertInterval57M {
    public static void main(String[] args) {
        int[][] intervals = { { 1, 3 }, { 6, 9 } };
        int[] newInterval = { 2, 5 };
        int[][] ans = insert(intervals, newInterval);
    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {
         List<int[]> list = new ArrayList<>();

        int[][] newArray = new int[intervals.length+1][2];
        System.arraycopy(intervals, 0, newArray, 0, intervals.length);
        newArray[intervals.length][0] = newInterval[0];
        newArray[intervals.length][1] = newInterval[1];

        Arrays.sort(newArray,(a,b)->{
            return a[0]-b[0];
        });

        int left = newArray[0][0];
        int right = newArray[0][1];

        for(int i=1;i<newArray.length;i++){
            if(newArray[i][0]<=right){
                right = Math.max(right, newArray[i][1]);
            }else{
                list.add(new int[]{left,right});
                left = newArray[i][0];
                right = newArray[i][1];
            }
        }
        list.add(new int[]{left,right});
        return list.toArray(new int[list.size()][]);
    }
}
