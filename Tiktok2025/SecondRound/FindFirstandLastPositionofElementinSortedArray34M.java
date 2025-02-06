package Tiktok2025.SecondRound;

// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
public class FindFirstandLastPositionofElementinSortedArray34M {
    public static void main(String[] args) {
        int[] nums = { 5, 7, 7, 8, 8, 10 };
        int target = 8;
        int[] ans = searchRange(nums, target);
        System.out.println(ans[0] + " " + ans[1]);
    }

    public static int[] searchRange(int[] nums, int target) {
        int left = findLeftBound(nums, target);
        int right = findRightBound(nums, target);
        if (left <= right) {
            return new int[] { left, right };
        }
        return new int[] { -1, -1 };
    }

    public static int findLeftBound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public static int findRightBound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }
}
