package Tiktok2025;

import java.util.Arrays;

// https://leetcode.com/problems/maximum-product-of-three-numbers/?envType=company&envId=tiktok&favoriteSlug=tiktok-six-months
public class MaximumProductofThreeNumbers628E {
    public static void main(String[] args) {
        int[] nums = { -100, -98, -1, 2, 3, 4 };
        System.out.println(maximumProductNoSort(nums));
    }

    public static int maximumProduct(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        return Math.max(nums[n - 1] * nums[n - 2] * nums[n - 3], nums[0] * nums[1] * nums[n - 1]);
    }

    public static int maximumProductNoSort(int[] nums) {
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num > max1) {
                max3 = max2;
                max2 = max1;
                max1 = num;
            } else if (num > max2) {
                max3 = max2;
                max2 = num;
            } else if (num > max3) {
                max3 = num;
            }

            if (num < min1) {
                min2 = min1;
                min1 = num;
            } else if (num < min2) {
                min2 = num;
            }
        }
        System.out.println(max1+" "+max2+" "+max3+" "+min1+" "+min2);
        return Math.max(max1 * max2 * max3, max1 * min1 * min2);
    }
}
