package Tiktok2025.Tiktok202504;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/permutations/
public class Permutations46M {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };
        System.out.println(permute(nums));
    }

    static List<List<Integer>> list = new ArrayList<>();

    public static List<List<Integer>> permute(int[] nums) {
        track(nums, new ArrayList<>());
        return list;
    }

    public static void track(int[] nums, List<Integer> array) {
        if(array.size()==nums.length){
            list.add(new ArrayList<>(array));
            return;
        }

        for(int i=0;i<nums.length;i++){
            if(array.contains(nums[i])){
                continue;
            }
            array.add(nums[i]);
            track(nums, array);
            array.remove(array.size()-1);
        }
    }
}
