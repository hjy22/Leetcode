package BinarySearch;

// https://leetcode.com/problems/search-in-rotated-sorted-array/
public class SearchinRotatedSortedArray33M {
    public static void main(String[] args) {
        int[] nums = { 4, 5, 6, 7, 0, 1, 2 };
        int target = 0;
        System.out.println(search(nums, target));
    }

    // 可理解为断层二分法
    public static int search(int[] nums, int target) {
        int left = 0, right = nums.length-1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }

            if (nums[mid] >= nums[left]) {
                if (target >= nums[left] && target < nums[mid]) {
                    // target 落在 [left..mid-1] 中
                    right = mid - 1;
                } else {
                    // target 落在 [mid+1..right] 中
                    left = mid + 1;
                }
            } else {
                if (target > nums[mid] && target <= nums[right]) {
                    // target 落在 [left..mid-1] 中
                    left = mid + 1;
                } else {
                    // target 落在 [mid+1..right] 中
                    right = mid - 1;
                }
            }
        }

        return -1;
    }

    public static int searchOn(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            }
        }
        return -1; // 如果没有找到目标元素，返回 -1
    }
}
