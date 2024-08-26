package Backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

// https://leetcode.com/problems/combination-sum-ii/
public class CombinationSumII40M {
    static List<List<Integer>> ans = new ArrayList<>();

    public static void main(String[] args) {
        int[] candidates = { 2, 3, 6, 7 };
        int target = 7;
        System.out.println(combinationSum2(candidates, target));
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);  // 排序是为了处理重复元素
        LinkedList<Integer> track = new LinkedList<>();
        backTrack(candidates, track, 0, target,0);
        return ans;
    }

    public static void backTrack(int[] nums, LinkedList<Integer> track, int sum, int target,int start) {
        if (sum == target) {
            ans.add(new ArrayList<>(track));
            return;
        }
        // 遍历
        for (int i = start; i < nums.length; i++) {
            // 如果当前数字和前一个数字相同，并且前一个数字还没有被使用，跳过
            if (i > 0 && nums[i] == nums[i - 1] && i > start) {
                continue;
            }
            if (sum + nums[i] > target) {
                continue;
            }
            
            // 加入元素
            track.add(nums[i]);
            sum += nums[i];
            // 递归，注意这里传递的是 i+1，因为每个元素只能使用一次
            backTrack(nums, track, sum, target, i + 1);
            // 删除元素
            track.removeLast();
            sum-=nums[i];
        }
    }
}
