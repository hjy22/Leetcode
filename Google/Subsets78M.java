package Google;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/subsets/
public class Subsets78M {
    static List<List<Integer>> ans = new ArrayList<>();

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };
        System.out.println(subsets(nums));
    }

    public static List<List<Integer>> subsets(int[] nums) {
        backTrack(nums, new ArrayList<>(), 0);
        return ans;
    }

    public static void backTrack(int[] nums, List<Integer> list, int start) {
        ans.add(new ArrayList<>(list));
        for (int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            backTrack(nums, list, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
