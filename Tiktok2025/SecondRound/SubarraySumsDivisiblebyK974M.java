package Tiktok2025.SecondRound;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/subarray-sums-divisible-by-k/
public class SubarraySumsDivisiblebyK974M {
    public static void main(String[] args) {
        int[] nums = { 4, 5, 0, -2, -3, 1 };
        int k = 5;
        System.out.println(subarraysDivByK(nums, k));
    }

    public static int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int prefixSum = 0, count = 0;
        map.put(0, 1);
        for (int num : nums) {
            prefixSum = (prefixSum+num)%k;
            if(prefixSum<0){
                prefixSum+=k;
            }
            if(map.containsKey(prefixSum)){
                count+=map.get(prefixSum);
            }
            map.put(prefixSum, map.getOrDefault(prefixSum, 0)+1);
        }
        return count;
    }
}
