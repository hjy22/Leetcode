package Backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

// https://leetcode.com/problems/permutations-ii/
public class PermutationsII47M {
    static List<List<Integer>> ans = new ArrayList<>();

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };
        System.out.println(permuteUnique(nums));
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        LinkedList<Integer> track = new LinkedList<>();
        boolean[] used = new boolean[nums.length];
        backTrack(nums, track, used);
        return ans;
    }

    public static void backTrack(int[] nums, LinkedList<Integer> track, boolean[] used) {
        // base step - 弹出条件
        if (track.size() == nums.length) {
            ans.add(new ArrayList<>(track));
            return;
        }

        // 遍历
        for (int i = 0; i < nums.length; i++) {
            // 跳过重复项
            if (used[i] == true) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            // 加入元素
            track.add(nums[i]);
            used[i] = true;
            // backtrack
            backTrack(nums, track, used);
            // 删除元素
            track.removeLast();
            used[i] = false;
        }
    }
}
