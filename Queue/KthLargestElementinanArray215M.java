package Queue;

import java.util.PriorityQueue;

//https://leetcode.com/problems/kth-largest-element-in-an-array/
public class KthLargestElementinanArray215M {
    public static void main(String[] args) {
        int[] nums = { 3,2,3,1,2,4,5,5,6 };
        int k = 4;
        System.out.println(findKthLargest(nums, k));
    }

    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(Integer i:nums){
            queue.add(i);
            if(queue.size()>k){
                queue.poll();
            }
        }
        return queue.poll();
    }
}
