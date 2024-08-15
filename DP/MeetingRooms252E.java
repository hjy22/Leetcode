package DP;

import java.util.Arrays;

//https://leetcode.com/problems/meeting-rooms/
public class MeetingRooms252E {
    public static void main(String[] args) {
        int[][] intervals = { { 0, 30 }, { 5, 10 }, { 15, 20 } };
        System.out.println(canAttendMeetings(intervals));
    }

    public static boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            return a[0] - b[0];
        });
        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0]<intervals[i-1][1]){
                return false;
            }
        }
        return true;
    }

    public static boolean canAttendMeetings2(int[][] intervals) {
        if (intervals.length < 1) {
            return true;
        }
        int ans = 0;
        int[] begin = new int[intervals.length];
        int[] end = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            begin[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        Arrays.sort(begin);
        Arrays.sort(end);

        int i = 0, j = 0, count = 0;
        ;
        while (i < intervals.length && j < intervals.length) {
            if (begin[i] < end[j]) {
                // it starts
                count++;
                i++;
            } else {
                // end
                count--;
                j++;
            }
            ans = Math.max(ans, count);
        }
        return ans == 1;
    }
}
