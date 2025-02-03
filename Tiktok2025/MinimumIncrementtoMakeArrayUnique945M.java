package Tiktok2025;

import java.util.Arrays;

// https://leetcode.com/problems/minimum-increment-to-make-array-unique/?envType=company&envId=tiktok&favoriteSlug=tiktok-six-months
public class MinimumIncrementtoMakeArrayUnique945M {
    public static void main(String[] args) {
        int[] nums = { 2, 2, 2, 1 };
        System.out.println(minIncrementForUnique(nums));
        System.out.println(minIncrementForUniqueNoSort(nums));
    }

    public static int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);
        int uniqueNum = nums[0];
        int move = 0;
        for (int num : nums) {
            if (num < uniqueNum) {
                move += uniqueNum - num;
            }
            uniqueNum = Math.max(uniqueNum, num) + 1;
        }
        return move;
    }

    public static int minIncrementForUniqueNoSort(int[] nums) {
        int maxNum = 0;
        for (int num : nums) {
            maxNum = Math.max(maxNum, num);
        }

        int[] count = new int[nums.length + maxNum];
        for (int num : nums) {
            count[num]++;
        }

        int move = 0;
        for (int i = 0; i < count.length - 1; i++) {
            if (count[i] > 1) {
                int times = count[i] - 1;
                count[i + 1] += times;
                move += times;
                count[i] = 1;
            }
        }
        return move;
    }
}
