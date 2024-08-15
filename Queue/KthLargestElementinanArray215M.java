package Queue;

import java.util.PriorityQueue;

//https://leetcode.com/problems/kth-largest-element-in-an-array/
public class KthLargestElementinanArray215M {
    public static void main(String[] args) {
        int[] nums = { 3, 2, 3, 1, 2, 4, 5, 5, 6 };
        int k = 4;
        System.out.println(findKthLargest(nums, k));
    }

    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (Integer i : nums) {
            queue.add(i);
            // 如果堆的大小超过 k，则删除堆顶元素
            if (queue.size() > k) {
                queue.poll();
            }
        }
        // 堆顶元素就是第 k 大的元素
        return queue.poll();
    }
}
