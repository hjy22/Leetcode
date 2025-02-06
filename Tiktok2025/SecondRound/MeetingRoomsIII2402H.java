package Tiktok2025.SecondRound;

import java.util.Arrays;
import java.util.PriorityQueue;

// https://leetcode.com/problems/meeting-rooms-iii/
public class MeetingRoomsIII2402H {
    public static void main(String[] args) {
        int[][] meetings = { { 0, 10 }, { 1, 5 }, { 2, 7 }, { 3, 4 } };
        int n = 2;
        System.out.println(mostBooked(n, meetings));
    }

    public static int mostBooked(int n, int[][] meetings) {
        int[] roomUsed = new int[n];
        Arrays.sort(meetings, (a, b) -> {
            return a[0] - b[0];
        });
        // {index,start}
        PriorityQueue<int[]> available = new PriorityQueue<>((a, b) -> {
            return a[0] - b[0];
        });
        for(int i=0;i<n;i++){
            available.add(new int[]{i,0});
        }

        // {index,end}
        PriorityQueue<int[]> busy = new PriorityQueue<>((a, b) -> {
            if (a[1] == b[1]) {
                return a[0] - b[0];
            } else {
                return a[1] - b[1];
            }
        });

        for (int[] meeting : meetings) {
            int start = meeting[0];
            int end = meeting[1];

            while (!busy.isEmpty() && busy.peek()[1] <= start) {
                int[] room = busy.poll();
                available.add(new int[] { room[0], room[1] });
            }

            if (!available.isEmpty()) {
                int[] room = available.poll();
                roomUsed[room[0]]++;
                busy.add(new int[] { room[0], end });
            } else {
                int[] room = busy.poll();
                roomUsed[room[0]]++;
                busy.add(new int[] { room[0], room[1] + (end - start) });
            }
        }

        int maxUsage = 0, index = -1;
        for (int i = 0; i < roomUsed.length; i++) {
            if (roomUsed[i] > maxUsage) {
                maxUsage = roomUsed[i];
                index = i;
            }
        }
        return index;
    }
}
