package Tiktok2025.SecondRound;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/subarray-sum-equals-k/
public class SubarraySumEqualsK560M {
    public static void main(String[] args) {
        int[] nums = { 1, 1, 1 };
        int k = 2;
        System.out.println(subarraySum(nums, k));
    }

    public static int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0, 1);
        int prefixSum=0,count=0;
        for(int i=0;i<nums.length;i++){
            prefixSum+=nums[i];
            if(map.containsKey(prefixSum-k)){
                count+=map.get(prefixSum-k);
            }
            map.put(prefixSum, map.getOrDefault(prefixSum, 0)+1);
        }
        return count;
    }
}
