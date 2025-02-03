package Tiktok2025;

import java.util.PriorityQueue;

// https://leetcode.com/problems/maximal-score-after-applying-k-operations/?envType=company&envId=tiktok&favoriteSlug=tiktok-six-months 
public class MaximalScoreAfterApplyingKOperations2530M {
    public static void main(String[] args) {
        int[] nums = { 10, 10, 10, 10, 10 };
        int k = 5;
        System.out.println(maxKelements(nums, k));
    }

    public static long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> {
            return b - a;
        });
        for (int num : nums) {
            queue.add(num);
        }
        long score = 0;
        while (k > 0) {
            int num = queue.poll();
            score += num;
            queue.add((int) Math.ceil((double)num / 3));
            k--;
        }
        return score;
    }
}
