package Array;

import java.util.HashMap;

//https://leetcode.com/problems/continuous-subarray-sum/description/
public class ContinuousSubarraySum523M {
    public static void main(String[] args) {
        int[] nums = { 23, 2, 4, 6, 7 };
        int k = 6;
        System.out.println(checkSubarraySum(nums, k));
    }

    public static boolean checkSubarraySum(int[] nums, int k) {
        int[] sumArray = new int[nums.length + 1];
        sumArray[0] = 0;
        for (int i = 1; i < sumArray.length; i++) {
            sumArray[i] = sumArray[i - 1] + nums[i-1];
        }

        HashMap<Integer, Integer> valToIndex = new HashMap<>();

        for (int i = 0; i < sumArray.length; i++) {
            int remainder = sumArray[i] % k;
            if (!valToIndex.containsKey(remainder)) {
                valToIndex.put(remainder, i);
            }
        }
        int res = 0;
        for (int i = 1; i < sumArray.length; i++) {
            // 计算 need，使得 (preSum[i] - need) % k == 0
            int need = sumArray[i] % k;
            if (valToIndex.containsKey(need)) {
                if (i - valToIndex.get(need) >= 2) {
                    // 这个子数组的长度至少为 2
                    return true;
                }
            }
        }
        return false;
    }
}
