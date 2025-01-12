package Tiktok2025;

import java.util.Arrays;

// https://leetcode.com/problems/meeting-rooms-ii/description/?envType=company&envId=tiktok&favoriteSlug=tiktok-thirty-days
public class MeetingRoomsII253M {
    public static void main(String[] args) {
        int[][] intervals = { { 7, 10 }, { 2, 4 } };
        System.out.println(minMeetingRooms(intervals));
    }

    public static int minMeetingRooms(int[][] intervals) {
        int[] begin = new int[intervals.length];
        int[] end = new int[intervals.length];

        int index = 0;
        for (int[] interval : intervals) {
            begin[index] = interval[0];
            end[index] = interval[1];
            index++;
        }

        Arrays.sort(begin);
        Arrays.sort(end);

        int i = 0, j = 0;
        int num = 0, max = 0;
        while (i < intervals.length && j < intervals.length) {
            if (begin[i] < end[j]) {
                num++;
                i++;
            } else {
                num--;
                j++;
            }
            max = Math.max(max, num);
        }
        if (i < intervals.length) {
            num += intervals.length - i;
            max = Math.max(max, num);
        }
        return max;
    }
}
