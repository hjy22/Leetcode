package RoundOne2025;

public class SubarrayProductLessThanK713M {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };
        int x = 0;
        System.out.println(numSubarrayProductLessThanK(nums, x));
    }

    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        int left = 0, right = 0;
        int product = 1;
        int count = 0;
        while (right < nums.length) {
            int i1 = nums[right];
            product *= i1;
            right++;

            while (product >= k && left < right) {
                int i2 = nums[left];
                product /= i2;
                left++;
            }
            count += right - left;
        }
        return count;
    }
}
