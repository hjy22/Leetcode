package RoundOne2025;

// https://leetcode.com/problems/split-array-largest-sum/
public class SplitArrayLargestSum410H {
    public static void main(String[] args) {
        int[] nums = { 7, 2, 5, 10, 8 };
        int target = 2;
        System.out.println(splitArray(nums, target));
    }

    public static int splitArray(int[] nums, int k) {
        int left = nums[0], right = 0;
        for (int weight : nums) {
            left = Math.max(weight, left);
            right += weight;
        }

        while (left <= right) {
            int mid = (left + right) / 2;
            if (calSpeed(nums, mid) <= k) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    public static int calSpeed(int[] nums, int x) {
        int days = 0;
        for (int i = 0; i < nums.length;) {
            int capSum = x;
            while (i < nums.length && capSum - nums[i] >= 0) {
                capSum -= nums[i];
                i++;
            }
            days++;
        }
        return days;
    }
}
