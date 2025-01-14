package Tiktok2025;

import java.util.ArrayList;
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
        backTrack(candidates, new ArrayList<>(), target, 0, 0);
        return ans;
    }

    public static void backTrack(int[] candidates, List<Integer> list, int target, int sum, int start) {
        if (sum == target) {
            ans.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (sum > target) {
                continue;
            }
            list.add(candidates[i]);
            sum += candidates[i];
            backTrack(candidates, list, target, sum, i);
            sum -= candidates[i];
            list.remove(list.size() - 1);
        }
    }
}
