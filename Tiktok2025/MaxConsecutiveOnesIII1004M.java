package Tiktok2025;

// https://leetcode.com/problems/max-consecutive-ones-iii/submissions/1526921635/?envType=company&envId=tiktok&favoriteSlug=tiktok-six-months
public class MaxConsecutiveOnesIII1004M {
    public static void main(String[] args) {
        int[] nums = { 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0 };
        int k = 2;
        System.out.println(longestOnes(nums, k));
    }

    public static int longestOnes(int[] nums, int k) {
        int left = 0, right = 0;
        int numZero = 0;
        int maxLength = 0;
        while (right < nums.length) {
            int i1 = nums[right];
            if (i1 == 0) {
                numZero++;
            }
            while (numZero > k) {
                int i2 = nums[left];
                if (i2 == 0) {
                    numZero--;
                }
                left++;
            }
            maxLength = Math.max(maxLength, right - left+1);
            right++;
        }
        return maxLength;
    }
}
