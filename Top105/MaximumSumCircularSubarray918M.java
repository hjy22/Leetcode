package Top105;

// https://leetcode.com/problems/maximum-sum-circular-subarray/?envType=study-plan-v2&envId=top-interview-150
public class MaximumSumCircularSubarray918M {
    public static void main(String[] args) {
        int[] nums = { -2};
        System.out.println(maxSubarraySumCircular(nums));
    }

    public static int maxSubarraySumCircular(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        int maxSum = nums[0];
        int minSum = nums[0];
        int totalSum = nums[0];
        int[] maxSumArray = new int[nums.length];
        int[] minSumArray = new int[nums.length];
        maxSumArray[0] = nums[0];
        minSumArray[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            totalSum += nums[i];
            int curMaxSum=Math.max(nums[i], maxSumArray[i-1]+nums[i]);
            maxSumArray[i]=curMaxSum;
            maxSum = Math.max(maxSum, curMaxSum);

            int curMinSum=Math.min(nums[i], minSumArray[i-1]+nums[i]);
            minSumArray[i]=curMinSum;
            minSum = Math.min(minSum, curMinSum);
        }
        // 如果 minSum 等于 totalSum，说明所有元素都是负数，此时返回 maxSum
        if (totalSum == minSum) {
            return maxSum;
        }
        return Math.max(maxSum,totalSum-minSum);
    }
}
