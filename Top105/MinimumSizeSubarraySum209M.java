package Top105;

// https://leetcode.com/problems/minimum-size-subarray-sum/description/?envType=study-plan-v2&envId=top-interview-150
public class MinimumSizeSubarraySum209M {
    public static void main(String[] args) {
        int target = 7;
        int[] nums = { 2, 3, 1, 2, 4, 3 };
        System.out.println(minSubArrayLen(target, nums));
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int left = 0, right = 0;
        int sum = 0;
        int minLength = Integer.MAX_VALUE;
        while (right<nums.length) {
            sum+=nums[right];
            right++;
            while (sum>=target) {
                minLength=Math.min(minLength, right-left);
                sum-=nums[left];
                left++;
            }
        }
        return minLength==Integer.MAX_VALUE?0:minLength;
    }
}
