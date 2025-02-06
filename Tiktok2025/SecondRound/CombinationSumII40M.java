package Tiktok2025.SecondRound;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII40M {
    public static void main(String[] args) {
        int[] candidates = { 10, 1, 2, 7, 6, 1, 5 };
        int target = 8;
        System.out.println(combinationSum(candidates, target));

    }

    static List<List<Integer>> ans = new ArrayList<>();

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        backTrack(candidates, target, 0, 0, new ArrayList<>());
        return ans;
    }

    public static void backTrack(int[] candidates, int target, int index, int sum, List<Integer> list) {
        if (sum == target) {
            ans.add(new ArrayList<>(list));
        }
        for (int i = index; i < candidates.length; i++) {
            if (sum > target) {
                continue;
            }
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }
            list.add(candidates[i]);
            sum += candidates[i];
            backTrack(candidates, target, i + 1, sum, list);
            list.remove(list.size() - 1);
            sum -= candidates[i];
        }
    }
}
