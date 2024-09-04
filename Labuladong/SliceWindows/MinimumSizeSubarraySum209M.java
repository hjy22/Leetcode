package Labuladong.SliceWindows;

// https://leetcode.com/problems/minimum-size-subarray-sum/
public class MinimumSizeSubarraySum209M {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 5 };
        int target = 11;
        System.out.println(minSubArrayLen(target, nums));
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int left = 0, right = 0;
        int minLength = Integer.MAX_VALUE;
        int sum = 0;
        while (right < nums.length) {
            int i = nums[right];
            sum += i;
            right++;
            while (sum >= target) {
                int j = nums[left];
                sum -= j;
                left++;
                minLength = Math.min(minLength, right - left + 1);
            }
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}
