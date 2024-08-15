package Array;

import java.util.Arrays;

//https://leetcode.com/problems/two-sum-less-than-k/
public class TwoSumLessThanK1099E {
    public static void main(String[] args) {
        int[] nums = { 34, 23, 1, 24, 75, 33, 54, 8 };
        int k = 60;
        System.out.println(twoSumLessThanK(nums, k));
    }

    // 对于数组的每一个nums[i],找k-nums[i]的最大值
    public static int twoSumLessThanK(int[] nums, int k) {
        Arrays.sort(nums);
        int ans = -1;
        for (int i = 0; i < nums.length; i++) {
            int max = binarySearch(nums, k - nums[i], i+1, nums.length - 1);
            if(max!=0){
                ans = Math.max(ans, max + nums[i]);
            }
        }
        return ans;
    }

    public static int binarySearch(int[] nums, int val, int low, int high) {
        int max = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > val) {
                high = mid - 1;
            } else if (nums[mid] < val) {
                max = nums[mid];
                low = mid + 1;
            }
        }
        return max;
    }

    public static int twoSumLessThanKLimit(int[] nums, int k) {
        int start = 0, end = nums.length - 1;
        int maxSum = -1;
        Arrays.sort(nums);
        while (start <= end) {
            int n1 = nums[start], n2 = nums[end];
            int sum = n1 + n2;
            if (sum <= k) {
                maxSum = Math.max(maxSum, sum);
                start++;
            } else {
                end--;
            }
        }
        return maxSum;
    }
}
