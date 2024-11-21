package Google;

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
        backTrack(candidates, target, new ArrayList<>(), 0, 0);
        return ans;
    }

    public static void backTrack(int[] candidates, int target,List<Integer> track, int start,int sum){
        if(sum==target){
            ans.add(new ArrayList<>(track));
            return;
        }
        if(sum>target){
            return;
        }
        for(int i=start;i<candidates.length;i++){
            if(sum>target){
                continue;
            }
            track.add(candidates[i]);
            sum+=candidates[i];
            backTrack(candidates, target, track, i, sum);
            sum-=candidates[i];
            track.remove(track.size()-1);
        }
    }
}
