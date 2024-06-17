package PrefixSum;

import java.util.HashMap;
import java.util.Map;

public class MaximumSizeSubarraySumEqualsk325M {
    public static void main(String[] args) {
        int[] nums = {1,-1,5,-2,3};
        int x=3;
        System.out.println(maxSubArrayLen(nums,x));
    }

    public static int maxSubArrayLen(int[] nums, int k) {
        int sum = 0,maxLen=0;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if (map.containsKey(sum - k)) {
                int previousIndex = map.get(sum - k);
                maxLen = Math.max(maxLen, i - previousIndex);
            }
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        return maxLen;
    }
}
