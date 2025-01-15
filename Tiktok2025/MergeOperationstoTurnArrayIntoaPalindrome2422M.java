package Tiktok2025;

// https://leetcode.com/problems/merge-operations-to-turn-array-into-a-palindrome/description/?envType=company&envId=tiktok&favoriteSlug=tiktok-three-months
public class MergeOperationstoTurnArrayIntoaPalindrome2422M {
    public static void main(String[] args) {
        int[] nums = { 4, 3, 2, 1, 2, 3, 1 };
        System.out.println(minimumOperations(nums));
    }

    public static int minimumOperations(int[] nums) {
        int left = 0, right = nums.length - 1;
        int operations = 0;
        while (left <= right) {
            if (nums[left] == nums[right]) {
                left++;
                right--;
            } else if (nums[left] < nums[right]) {
                nums[left + 1] += nums[left];
                left++;
                operations++;
            } else {
                nums[right - 1] += nums[right];
                right--;
                operations++;
            }
        }
        return operations;
    }
}
