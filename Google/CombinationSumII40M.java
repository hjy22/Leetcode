package Google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/combination-sum-ii/
public class CombinationSumII40M {
    static List<List<Integer>> ans = new ArrayList<>();

    public static void main(String[] args) {
        int[] candidates = { 10, 1, 2, 7, 6, 1, 5 };
        int target = 8;
        System.out.println(combinationSum2(candidates, target));
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backTrack(candidates, target, new ArrayList<>(), 0, 0);
        return ans;
    }

    public static void backTrack(int[] candidates, int target, List<Integer> track, int start, int sum) {
        if (sum == target) {
            ans.add(new ArrayList<>(track));
            return;
        }
        if (sum > target) {
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (sum > target) {
                continue;
            }
            if(i>start&&candidates[i]==candidates[i-1]){
                continue;
            }
            sum += candidates[i];
            track.add(candidates[i]);
            backTrack(candidates, target, track, i + 1, sum);
            sum -= candidates[i];
            track.remove(track.size() - 1);
        }
    }
}
