package Tiktok2025;

import java.util.PriorityQueue;

// https://leetcode.com/problems/kth-largest-element-in-an-array/?envType=company&envId=tiktok&favoriteSlug=tiktok-three-months
public class KthLargestElementinanArray215M {
    public static void main(String[] args) {
        int[] nums = { 3, 2, 1, 5, 6, 4 };
        int k = 2;
        System.out.println(findKthLargest(nums, k));
    }

    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int num:nums){
            queue.add(num);
            if(queue.size()>k){
                queue.poll();
            }
        }
        return queue.poll();
    }
}
