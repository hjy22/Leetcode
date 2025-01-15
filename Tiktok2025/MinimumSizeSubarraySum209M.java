package Tiktok2025;

// https://leetcode.com/problems/minimum-size-subarray-sum/description/?envType=company&envId=tiktok&favoriteSlug=tiktok-three-months
public class MinimumSizeSubarraySum209M {
    public static void main(String[] args) {
        int[] nums = { 2, 3, 1, 2, 4, 3 };
        int target = 7;
        System.out.println(minSubArrayLen(target, nums));
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int left = 0, right = 0;
        int minLength = Integer.MAX_VALUE;
        int sum = 0;
        while (right < nums.length) {
            int n1 = nums[right];
            sum += n1;

            while (sum >= target) {
                minLength = Math.min(minLength, right - left+1);
                int n2 = nums[left];
                sum -= n2;
                left++;
            }
            right++;
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}
