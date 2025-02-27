package RoundOne2025;

import java.util.TreeSet;

// https://leetcode.com/problems/contains-duplicate-iii/description/
public class ContainsDuplicateIII220H {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 1 };
        int indexDiff = 3, valueDiff = 0;
        System.out.println(containsNearbyAlmostDuplicate(nums, indexDiff, valueDiff));
    }

    public static boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            Integer floor = set.floor(nums[i]);
            if (floor != null && nums[i] - floor <= valueDiff) {
                return true;
            }

            Integer ceiling = set.ceiling(nums[i]);
            if (ceiling != null && ceiling - nums[i] <= valueDiff) {
                return true;
            }
            set.add(nums[i]);
            if (i >= indexDiff) {
                set.remove(nums[i - indexDiff]);
            }
        }
        return false;
    }

}
