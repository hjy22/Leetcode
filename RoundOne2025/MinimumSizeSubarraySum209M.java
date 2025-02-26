package RoundOne2025;

// https://leetcode.com/problems/minimum-size-subarray-sum/description/
public class MinimumSizeSubarraySum209M {
    public static void main(String[] args) {
        int[] nums = { 2, 3, 1, 2, 4, 3 };
        int x = 7;
        System.out.println(minSubArrayLen(x, nums));
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int sum = 0, minLength = Integer.MAX_VALUE;
        int left = 0, right = 0;
        while (right < nums.length) {
            int i1 = nums[right];
            sum += i1;
            right++;
            while (sum >= target) {
                minLength = Math.min(minLength, right - left);
                int i2 = nums[left];
                sum -= i2;
                left++;
            }
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}
