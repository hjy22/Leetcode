package Google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/permutations-ii/
public class PermutationsIIM {
    static List<List<Integer>> ans = new ArrayList<>();

    public static void main(String[] args) {
        int[] nums = { 1, 1, 2 };
        System.out.println(permuteUnique(nums));
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        backTrack(nums, new ArrayList<>(), used);
        return ans;
    }

    public static void backTrack(int[] nums, List<Integer> list, boolean[] used) {
        if (list.size() == nums.length) {
            ans.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            list.add(nums[i]);
            used[i] = true;
            backTrack(nums, list, used);
            list.remove(list.size() - 1);
            used[i] = false;
        }
    }
}
