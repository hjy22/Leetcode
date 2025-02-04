package Tiktok2025;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/combination-sum-iv/?envType=company&envId=tiktok&favoriteSlug=tiktok-six-months
public class CombinationSumIV377M {
    static List<List<Integer>> ans = new ArrayList<>();

    public static void main(String[] args) {
        int[] nums = { 4, 2, 1 };
        int target = 32;
        System.out.println(combinationSum4(nums, target));
    }

    public static int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i < dp.length; i++) {
            for (int num : nums) {
                if (i >= num) {
                    dp[i] += dp[i - num];
                }
            }
        }
        return dp[target];
    }

    public static int combinationSum4BackTrack(int[] nums, int target) {
        backTrack(nums, target, new ArrayList<>(), 0, 0);
        System.out.println(ans);
        return ans.size();
    }

    public static void backTrack(int[] nums, int target, List<Integer> list, int index, int sum) {
        if (sum == target) {
            ans.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (sum + nums[i] > target) {
                continue;
            }
            sum += nums[i];
            list.add(nums[i]);
            backTrack(nums, target, list, i, sum);
            sum -= nums[i];
            list.remove(list.size() - 1);
        }
    }
}
