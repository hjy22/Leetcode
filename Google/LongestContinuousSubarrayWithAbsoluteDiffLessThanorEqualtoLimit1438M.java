package Google;

import java.util.ArrayDeque;
import java.util.Deque;

// https://leetcode.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/
public class LongestContinuousSubarrayWithAbsoluteDiffLessThanorEqualtoLimit1438M {
    public static void main(String[] args) {
        int[] nums = { 4,2,2,2,4,4,2,2 };
        int limit = 0;
        System.out.println(longestSubarray(nums, limit));
    }

    public static int longestSubarray(int[] nums, int limit) {
        Deque<Integer> maxDeque = new ArrayDeque<>();
        Deque<Integer> minDeque = new ArrayDeque<>();
        int left = 0, right = 0;
        int maxLength = 0;
        while (right < nums.length) {
            while (!maxDeque.isEmpty() && nums[maxDeque.peekLast()] < nums[right]) {
                maxDeque.pollLast();
            }
            maxDeque.offerLast(right);

            while (!minDeque.isEmpty() && nums[minDeque.peekLast()] > nums[right]) {
                minDeque.pollLast();
            }
            minDeque.offerLast(right);
            while (nums[maxDeque.peekFirst()] - nums[minDeque.peekFirst()] > limit) {
                left++;
                // 移除窗口左侧不再有效的元素
                if (maxDeque.peekFirst() < left) {
                    maxDeque.pollFirst();
                }
                if (minDeque.peekFirst() < left) {
                    minDeque.pollFirst();
                }
            }
            maxLength = Math.max(maxLength, right - left+1);
            right++;
        }
        return maxLength;
    }
}
