package SuiXiangLu;

// https://leetcode.com/problems/minimum-size-subarray-sum/
public class MinimumSizeSubarraySum209M {
    public static void main(String[] args) {
        int target = 11;
        int[] nums = { 1,2,3,4,5};
        System.out.println(minSubArrayLen(target, nums));
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int left = 0, right = 0;
        int minLength = Integer.MAX_VALUE;
        int sum = 0;
        while (right < nums.length) {
            int i1 = nums[right];
            sum += i1;
            right++;

            while (sum >= target) {
                int i2 = nums[left];
                sum-=i2;
                left++;
                minLength = Math.min(minLength, right - left);

            }

        }
        return minLength==Integer.MAX_VALUE?0:minLength;
    }
}
