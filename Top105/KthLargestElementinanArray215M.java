package Top105;

import java.util.PriorityQueue;

// https://leetcode.com/problems/kth-largest-element-in-an-array/?envType=study-plan-v2&envId=top-interview-150
public class KthLargestElementinanArray215M {
    public static void main(String[] args) {
        int[] nums = { 3, 2, 1, 5, 6, 4 };
        int k = 2;
        System.out.println(findKthLargest(nums, k));
    }

    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (Integer num : nums) {
            queue.offer(num);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        return queue.poll();
    }
}
