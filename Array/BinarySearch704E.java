package Array;

//https://leetcode.com/problems/binary-search/
public class BinarySearch704E {
    public static void main(String[] args) {
        int[] nums = { -1, 0, 3, 5, 9, 12 };
        int target = 9;
        System.out.println(search(nums, target));
    }

    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        int ans = -1;
        while (left < right) {
            int middle = left + (right - left) / 2;
            if (nums[middle] == target) {
                ans = middle;
                break;
            } else if (nums[middle] > target) {
                right = middle;
            } else {
                left = middle + 1;
            }
        }
        return ans;
    }
}
