package Labuladong.SliceWindows;

import java.util.Arrays;

//https://leetcode.com/problems/3sum-smaller/description/
public class ThreeSumSmaller259M {
    public static void main(String[] args) {
        int[] nums = { -2,0,1,3};
        int target = 2;
        System.out.println(threeSumSmaller(nums,target));
    }
    public static int threeSumSmaller(int[] nums, int target) {
        if (nums.length < 3) {
            return 0;
        }
        // 别忘了要先排序数组
        Arrays.sort(nums);
        int res = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            // 固定 nums[i] 为三数之和中的第一个数，
            // 然后对 nums[i+1..] 搜索小于 target - nums[i] 的两数之和个数
            res += twoSumSmaller(nums, i + 1, target - nums[i]);
        }
        return res;
    }

    // 在 nums[start..] 搜索小于 target 的两数之和个数
    static int  twoSumSmaller(int[] nums, int start, int target) {
        int lo = start, hi = nums.length - 1;
        int count = 0;
        while (lo < hi) {
            if (nums[lo] + nums[hi] < target) {
                // nums[lo] 和 nums[lo+1..hi]
                // 中的任一元素之和都小于 target
                count += hi - lo;
                lo++;
            } else {
                hi--;
            }
        }
        return count;
    }
}
