package Top105;

// https://leetcode.com/problems/search-insert-position/?envType=study-plan-v2&envId=top-interview-150
public class SearchInsertPosition35E {
    public static void main(String[] args) {
        int[] nums = { 1, 3, 5, 6 };
        int k = 5;
        System.out.println(searchInsert(nums, k));
    }

    public static int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length-1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left=mid+1;
            } else if (nums[mid] > target) {
                right=mid-1;
            }
        }
        return left;
    }
}
