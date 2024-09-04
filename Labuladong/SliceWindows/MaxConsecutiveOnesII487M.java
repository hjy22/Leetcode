package Labuladong.SliceWindows;

// https://leetcode.com/problems/max-consecutive-ones-ii/
public class MaxConsecutiveOnesII487M {
    public static void main(String[] args) {
        int[] nums = { 1, 0, 1, 1, 0 };
        System.out.println(findMaxConsecutiveOnes(nums));
    }

    public static int findMaxConsecutiveOnes(int[] nums) {
        int left=0,right=0;
        int maxLen =0,sum=0;
        while(right<nums.length){
            sum+=nums[right];
            right++;
            while (right-left>sum+1) {
                sum-=nums[left];
                left++;
            }
            maxLen=Math.max(maxLen, right-left);
        }
        return maxLen;
    }
}
