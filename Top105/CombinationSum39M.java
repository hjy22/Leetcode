package Top105;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/combination-sum/?envType=study-plan-v2&envId=top-interview-150
public class CombinationSum39M {
    static List<List<Integer>> ans = new ArrayList<>();

    public static void main(String[] args) {
        int[] candidates = { 2, 3, 6, 7 };
        int target = 7;
        System.out.println(combinationSum(candidates, target));
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> list = new ArrayList<>();
        backtrack(candidates, target, 0, 0,list);
        return ans;
    }

    public static void backtrack(int[] candidates, int target,int index,int sum,List<Integer> list) {
        if(sum==target){
            ans.add(new ArrayList<>(list));
            return;
        }
        
        for(int i=index;i<candidates.length;i++){
            if(sum+candidates[i]>target){
                continue;
            }
            sum+=candidates[i];
            list.add(candidates[i]);
            //从当前开始，数组的元素可以重复使用
            backtrack(candidates, target, i, sum, list);
            list.remove(list.size()-1);
            sum-=candidates[i];
        }
    }
}
