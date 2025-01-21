package Tiktok2025;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// https://leetcode.com/problems/non-decreasing-subsequences/description/
public class NondecreasingSubsequences491M {
    static List<List<Integer>> ans = new ArrayList<>();

    public static void main(String[] args) {
        int[] nums = { 4, 6, 7, 7 };
        System.out.println(findSubsequences(nums));
    }

    public static List<List<Integer>> findSubsequences(int[] nums) {
        backTrack(nums, 0, new ArrayList<>());
        return ans;
    }

    public static void backTrack(int[] nums, int index, List<Integer> list) {
        if (list.size() >= 2) {
            ans.add(new ArrayList<>(list));
        }
       Set<Integer> used = new HashSet<>(); 
        for (int i = index; i < nums.length; i++) {
            if (used.contains(nums[i])) {
                continue;
            }
            if (list.isEmpty() || nums[i] >= list.get(list.size() - 1)) {
                 used.add(nums[i]);
                list.add(nums[i]);
                backTrack(nums, i + 1, list);
                list.remove(list.size() - 1);
            }
        }
    }
}
