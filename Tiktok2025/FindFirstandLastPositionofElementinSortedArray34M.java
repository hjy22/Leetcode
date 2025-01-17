package Tiktok2025;

// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/?envType=company&envId=tiktok&favoriteSlug=tiktok-three-months
public class FindFirstandLastPositionofElementinSortedArray34M {
    public static void main(String[] args) {
        int[] nums = { 5, 7, 7, 8, 8, 10 };
        int target = 9;
        System.out.println(searchRange(nums, target));
    }

    public static int[] searchRange(int[] nums, int target) {
        int start = findStart(nums, target);
        int end = findEnd(nums, target);
        if (start <= end && nums[start] == target && nums[end] == target) {
            return new int[] { start, end };
        }
        return new int[] { -1, -1 };
    }

    public static int findStart(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static int findEnd(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }
}
