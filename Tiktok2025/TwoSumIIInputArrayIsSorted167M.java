package Tiktok2025;

// https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
public class TwoSumIIInputArrayIsSorted167M {
    public static void main(String[] args) {
        int[] nums = { 2, 7, 11, 15 };
        int target = 9;
        int[] ans = twoSum(nums, target);
        System.out.println(ans[0] + " " + ans[1]);
    }

    public static int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        while (left <= right) {
            int sum = numbers[left] + numbers[right];
            if (sum > target) {
                right--;
            } else if (sum < target) {
                left++;
            } else {
                return new int[] { left + 1, right + 1 };
            }
        }
        return new int[] { -1, -1 };
    }
}
