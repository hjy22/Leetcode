package Tiktok2025;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/find-all-duplicates-in-an-array/?envType=company&envId=tiktok&favoriteSlug=tiktok-six-months
public class FindAllDuplicatesinanArray442M {
    public static void main(String[] args) {
        int[] nums = { 4, 3, 2, 7, 8, 2, 3, 1 };
        System.out.println(findDuplicates(nums));
    }

    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        for (int i : nums) {
            if (nums[Math.abs(i) - 1] >= 0) {
                nums[Math.abs(i) - 1] *= -1;
            } else {
                ans.add(Math.abs(i));
            }
        }
        return ans;
    }
}
