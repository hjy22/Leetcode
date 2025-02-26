package RoundOne2025;

public class MinimumOperationstoReduceXtoZero1658M {
    public static void main(String[] args) {
        int[] nums = { 5, 6, 7, 8, 9 };
        int x = 4;
        System.out.println(minOperations(nums, x));
    }

    public static int minOperations(int[] nums, int x) {
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        int target = sum - x;

        int left = 0, right = 0;
        int maxLength = -1;
        sum = 0;
        while (right < nums.length) {
            int i1 = nums[right];
            sum += i1;
            right++;

            while (sum > target && left < nums.length) {
                int i2 = nums[left];
                sum -= i2;
                left++;
            }
            if (sum == target) {
                maxLength = Math.max(maxLength, right - left);
            }
        }
        return maxLength == -1 ? -1 : nums.length - maxLength;
    }
}
