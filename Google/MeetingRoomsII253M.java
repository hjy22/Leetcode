package Google;

import java.util.Arrays;

// https://leetcode.com/problems/meeting-rooms-ii/?envType=company&envId=google&favoriteSlug=google-thirty-days
public class MeetingRoomsII253M {
    public static void main(String[] args) {
        int[][] intervals = { { 0, 30 }, { 5, 10 }, { 15, 20 } };
        System.out.println(minMeetingRooms(intervals));
    }

    public static int minMeetingRooms(int[][] intervals) {
        int[] beginTime = new int[intervals.length];
        int[] endTime = new int[intervals.length];

        int index = 0;
        for (int[] interval : intervals) {
            beginTime[index] = interval[0];
            endTime[index] = interval[1];
            index++;
        }

        Arrays.sort(beginTime);
        Arrays.sort(endTime);

        int count = 0, max = 0;
        int i = 0, j = 0;

        //遍历开始和结束的时间，如果遇到开始count++，遇到结束count--
        //计算需要的最大数量
        while (i < intervals.length && j < intervals.length) {
            if(beginTime[i]<endTime[j]){
                count++;
                i++;
            }else{
                count--;
                j++;
            }
            max = Math.max(max, count);
        }
        return max;
    }
}
