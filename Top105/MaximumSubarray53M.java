package Top105;

// https://leetcode.com/problems/maximum-subarray/?envType=study-plan-v2&envId=top-interview-150
public class MaximumSubarray53M {
    public static void main(String[] args) {
        int[] nums = { 5,-3,5,5,-3,5 };
        System.out.println(maxSubArray(nums));
    }

    public static int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int[] sumArray = new int[nums.length];
        sumArray[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int curSum=Math.max(nums[i], sumArray[i-1]+nums[i]);
            sumArray[i]=curSum;
            maxSum = Math.max(maxSum, curSum);
        }
        return maxSum;
    }
}
