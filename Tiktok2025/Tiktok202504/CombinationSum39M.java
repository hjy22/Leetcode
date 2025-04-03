package Tiktok2025.Tiktok202504;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/combination-sum/?envType=company&envId=tiktok&favoriteSlug=tiktok-six-months&difficulty=MEDIUM
public class CombinationSum39M {
    public static void main(String[] args) {
        int[] candidates = { 2, 3, 6, 7 };
        int target = 7;
        System.out.println(combinationSum(candidates, target));
    }

    static List<List<Integer>> list = new ArrayList<>();

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        track(candidates, new ArrayList<>(), target, 0, 0);
        return list;
    }

    public static void track(int[] candidates, List<Integer> arr, int target, int sum,int index) {
        if(sum==target){
            list.add(new ArrayList<>(arr));
            return;
        }

        for(int i=index;i<candidates.length;i++){
            if(sum+candidates[i]>target){
                continue;
            }
            sum+=candidates[i];
            arr.add(candidates[i]);
            track(candidates, arr, target, sum, i);
            sum-=candidates[i];
            arr.remove(arr.size()-1);
        }
    }
}
