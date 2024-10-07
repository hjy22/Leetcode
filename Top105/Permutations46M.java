package Top105;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/permutations/description/
public class Permutations46M {
    static  List<List<Integer>> ans= new ArrayList<>();
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(permute(nums));
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<Integer> list = new ArrayList<>();
        backtrack(nums,list);
        return ans;
    }

    public static void backtrack(int[] nums,List<Integer> list){
        if(list.size()==nums.length){
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i:nums){
            if (list.contains(i)){
                continue;
            } 
            list.add(i);
            backtrack(nums, list);
            list.remove(list.size()-1);
        }
    }
}
