package Tiktok2025;

import java.util.PriorityQueue;

// https://leetcode.com/problems/furthest-building-you-can-reach/?envType=company&envId=tiktok&favoriteSlug=tiktok-thirty-days
public class FurthestBuildingYouCanReach1642M {
    public static void main(String[] args) {
        int[] height = { 4,12,2,7,3,18,20,3,19};
        int bricks = 10, ladders = 2;
        System.out.println(furthestBuilding(height, bricks, ladders));
    }

    public static int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int bricksUsed = 0;
        for (int i = 0; i < heights.length - 1; i++) {
            int diff = heights[i + 1] - heights[i];
            if (diff < 0) {
                continue;
            }
            queue.add(diff);
            if (queue.size() > ladders) {
                bricksUsed += queue.poll();
            }
            if (bricksUsed > bricks) {
                return i;
            }
        }
        return heights.length-1;
    }
}
