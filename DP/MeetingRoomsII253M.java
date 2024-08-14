package DP;

import java.util.Arrays;

//https://leetcode.com/problems/meeting-rooms-ii/
public class MeetingRoomsII253M {
    public static void main(String[] args) {
        int[][] intervals = { { 0, 30 }, { 5, 10 }, { 15, 20 } };
        System.out.println(minMeetingRooms(intervals));
    }

    public static int minMeetingRooms(int[][] intervals) {
        int ans=0;
        int[] begin = new int[intervals.length];
        int[] end = new int[intervals.length];
        for(int i=0;i<intervals.length;i++){
            begin[i]=intervals[i][0];
            end[i]=intervals[i][1];
        }
        Arrays.sort(begin);
        Arrays.sort(end);

        int i=0,j=0,count=0;;
        while(i<intervals.length&&j<intervals.length){
            if(begin[i]<end[j]){
                //it starts
                count++;
                i++;
            }else{
                //end
                count--;
                j++;
            }
            ans=Math.max(ans, count);
        }
        return ans;
    }
}
