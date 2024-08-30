package Array;

// https://leetcode.com/problems/rotate-array/
public class RotateArray189M {
    public static void main(String[] args) {
        int[] nums = { 1, 2};
        int k = 2;
        rotate(nums, k);
        for (int i : nums) {
            System.out.print(i + " ");
        }

    }

    /*
     * k=2
     * 12345 -> 54321
     * 54321->45321
     * 45321->45123
     */
    public static void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k-1);
        reverse(nums, k , nums.length - 1);
    }

    public static void reverse(int[] nums, int start, int end) {
        while (start <= end) {
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }
}
