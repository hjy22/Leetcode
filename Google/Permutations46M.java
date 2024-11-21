package Google;

import java.util.ArrayList;
import java.util.List;

public class Permutations46M {
    static List<List<Integer>> ans = new ArrayList<>();

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };
        System.out.println(permute(nums));
    }

    public static List<List<Integer>> permute(int[] nums) {
        backTrack(new ArrayList<>(), nums);
        return ans;
    }

    public static void backTrack(List<Integer> list, int[] nums) {
        if (list.size() == nums.length) {
            ans.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if(list.contains(nums[i])){
                continue;
            }
            list.add(nums[i]);
            backTrack(list, nums);
            list.remove(list.size() - 1);
        }
    }
}
