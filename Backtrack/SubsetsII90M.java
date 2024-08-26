package Backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

// https://leetcode.com/problems/subsets-ii/
public class SubsetsII90M {
    static List<List<Integer>> ans = new ArrayList<>();

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };
        System.out.println(subsetsWithDup(nums));
    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(nums, track, 0);
        return ans;
    }

    public static void backtrack(int[] nums, LinkedList<Integer> track, int start) {
        ans.add(new ArrayList<>(track));
        for (int i = start; i < nums.length; i++) {
            if(i>start&&nums[i]==nums[i-1]){
                continue;
            }
            track.add(nums[i]);
            backtrack(nums, track, i + 1);
            track.removeLast();
        }
    }
}
