package Tiktok2025.SecondRound;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/combination-sum/
public class CombinationSum39M {
    public static void main(String[] args) {
        int[] candidates = { 2, 3, 6, 7 };
        int target = 7;
        System.out.println(combinationSum(candidates, target));

    }

    static List<List<Integer>> ans = new ArrayList<>();

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        backTrack(candidates, target, 0, 0, new ArrayList<>());
        return ans;
    }

    public static void backTrack(int[] candidates, int target, int index, int sum,List<Integer> list) {
        if(sum==target){
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i=index;i<candidates.length;i++){
            if(sum>target){
                continue;
            }
            sum+=candidates[i];
            list.add(candidates[i]);
            backTrack(candidates, target, i, sum, list);
            sum-=candidates[i];
            list.remove(list.size()-1);
        }
    }
}
