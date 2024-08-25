package Backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// https://leetcode.com/problems/combination-sum/
public class CombinationSum39M {
    static List<List<Integer>> ans = new ArrayList<>();

    public static void main(String[] args) {
        int[] candidates = { 2, 3, 6, 7 };
        int target = 7;
        System.out.println(combinationSum(candidates, target));
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        LinkedList<Integer> track = new LinkedList<>();
        backTrack(candidates, track, 0, target,0);
        return ans;
    }

    //加入start进backtrack的param是因为，如果每次都从0开始会有重复的元素
    public static void backTrack(int[] nums, LinkedList<Integer> track, int sum, int target,int start) {
        if (sum == target) {
            ans.add(new ArrayList<>(track));
            return;
        }
        // 遍历
        for (int i = start; i < nums.length; i++) {
            // 跳过重复项
            if (sum > target) {
                continue;
            }
            // 加入元素
            track.add(nums[i]);
            sum += nums[i];
            // backtrack
            backTrack(nums, track, sum, target,i);
            // 删除元素
            track.removeLast();
            sum -= nums[i];
        }
    }

}
