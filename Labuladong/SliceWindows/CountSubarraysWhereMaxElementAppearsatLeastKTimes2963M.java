package Labuladong.SliceWindows;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/count-subarrays-where-max-element-appears-at-least-k-times/
public class CountSubarraysWhereMaxElementAppearsatLeastKTimes2963M {
    public static void main(String[] args) {
        int[] nums = { 2,2,2,2,1,3,3,2,2,1,1,3,1,1,2,3,2,1,1,2,1,1,2,1,2,1,2,1,3,1,3,3};
        int k = 5;
        System.out.println(countSubarrays(nums, k));
    }

    public static long countSubarrays(int[] nums, int k) {
        int maxInt = 0;
        for (int num : nums) {
            maxInt = Math.max(maxInt, num);
        }
        int left = 0, right = 0;
        long times = 0;
        Map<Integer, Integer> numMap = new HashMap<>();
        while (right < nums.length) {
            int i = nums[right];
            numMap.put(i, numMap.getOrDefault(i, 0) + 1);
            while (numMap.getOrDefault(maxInt, 0) >= k) {
                //要包括>right所有的元素
                /*
                 * {1,2,1,2,0} k =2
                 * 当前计算到{1,2}
                 * 其实{1,2},{1,2,1},{1,2,1,2},{1,2,1,2,0}都算
                 * 所以这里的time+=长度-right
                 */
                times += nums.length - right;
                int j = nums[left];
                numMap.put(j, numMap.get(j) - 1);
                left++;
            }
            right++;
        }
        return times;
    }
}
