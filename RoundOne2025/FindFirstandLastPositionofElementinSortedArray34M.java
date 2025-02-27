package RoundOne2025;

// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/
public class FindFirstandLastPositionofElementinSortedArray34M {
    public static void main(String[] args) {
        int[] nums = { 5, 7, 7, 8, 8, 10 };
        int target = 5;
        System.out.println(searchRange(nums, target));
    }

    public static int[] searchRange(int[] nums, int target) {
        int left = findLeft(nums, target);
        int right = findRight(nums, target);
        if (left <= right) {
            return new int[] { left, right };
        }
        return new int[] { -1, -1 };
    }

    public static int findLeft(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public static int findRight(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }
}
