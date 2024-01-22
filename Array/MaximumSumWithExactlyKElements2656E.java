package Array;

import java.util.Arrays;

//https://leetcode.com/problems/maximum-sum-with-exactly-k-elements/
public class MaximumSumWithExactlyKElements2656E {
    public static void main(String[] args) {
        int[] nums = { 4, 3, 2, 3, 1 };
        int k = 1;
        System.out.println(maximizeSum(nums, k));
    }

    public static int maximizeSum(int[] nums, int k) {
        int ans = 0;
        Arrays.sort(nums);
        int maxValue = nums[nums.length - 1];
        ans = maxValue * k + (1+(k-1))*(k-1)/2;
        return ans;
    }
}
