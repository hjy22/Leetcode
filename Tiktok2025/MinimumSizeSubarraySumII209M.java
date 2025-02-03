package Tiktok2025;

public class MinimumSizeSubarraySumII209M {
    public static void main(String[] args) {
        int target = 7;
        int[] nums = { 2, 3, 1, 2, 4, 3 };
        System.out.println(minSubArrayLen(target, nums));
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int left = 0, right = 0;
        int sum = 0, minLen = Integer.MAX_VALUE;
        while (right < nums.length) {
            int i1 = nums[right];
            sum += i1;
            while (sum >= target) {
                int i2 = nums[left];
                sum -= i2;
                minLen = Math.min(minLen, right - left + 1);
                left++;
            }
            right++;
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}
