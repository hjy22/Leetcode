package Array;

//https://leetcode.com/problems/left-and-right-sum-differences
public class LeftandRightSumDifferences2574E {
    public static void main(String[] args) {
        int[] nums = { 10,4,8,3 };
        System.out.println(leftRightDifference(nums));
    }

    public static int[] leftRightDifference(int[] nums) {
        int[] leftSum = new int[nums.length];
        int[] rightSum = new int[nums.length];
        int[] ans = new int[nums.length];
        leftSum[0] = 0;
        for (int i = 0; i < nums.length-1; i++) {
            leftSum[i+1] = leftSum[i] + nums[i];
        }
        rightSum[nums.length - 1] = 0;
        for (int i = nums.length - 1; i > 0; i--) {
            rightSum[i-1] = rightSum[i] + nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            ans[i] = Math.abs(leftSum[i] - rightSum[i]);
        }
        return ans;
    }
}
