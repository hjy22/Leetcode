package Tiktok2025.SecondRound;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/permutations/
public class Permutations46M {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };
        System.out.println(permute(nums));
    }

    static List<List<Integer>> ans = new ArrayList<>();

    public static List<List<Integer>> permute(int[] nums) {
        backTrack(nums, new ArrayList<>());
        return ans;
    }

    public static void backTrack(int[] nums, List<Integer> list) {
        if (list.size() == nums.length) {
            ans.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (list.contains(nums[i])) {
                continue;
            }
            list.add(nums[i]);
            backTrack(nums, list);
            list.remove(list.size() - 1);
        }
    }
}
