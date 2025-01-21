package Tiktok2025;

import java.util.Arrays;

// https://leetcode.com/problems/partition-to-k-equal-sum-subsets/
public class PartitiontoKEqualSumSubsets698M {
    public static void main(String[] args) {
        int[] nums = { 4, 3, 2, 3, 5, 2, 1 };
        int k = 4;
        System.out.println(canPartitionKSubsets(nums, k));
    }

    public static boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        if (sum % k != 0) {
            return false;
        }
        int target = sum / k;
        Arrays.sort(nums);
        for (int i = 0, j = nums.length - 1; i < j; i++, j--) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        return backTrack(nums, k, 0, 0, target, new boolean[nums.length]);
    }

    public static boolean backTrack(int[] nums, int k, int start, int sum, int target, boolean[] used) {
        if (k == 0) {
            return true;
        }
        if (sum == target) {
            return backTrack(nums, k - 1, 0, 0, target, used);
        }
        for (int i = start; i < nums.length; i++) {
            if (used[i] || sum + nums[i] > target) {
                continue;
            }
            if (i > start && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            used[i] = true;
            if (backTrack(nums, k, i + 1, sum + nums[i], target, used)) {
                return true;
            }
            used[i] = false;
        }
        return false;
    }
}
