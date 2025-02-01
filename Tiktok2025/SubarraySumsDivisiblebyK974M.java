package Tiktok2025;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/subarray-sums-divisible-by-k/?envType=company&envId=tiktok&favoriteSlug=tiktok-six-months
public class SubarraySumsDivisiblebyK974M {
    public static void main(String[] args) {
        int[] nums = { 4, 5, 0, -2, -3, 1 };
        int k = 5;
        System.out.println(subarraysDivByK(nums, k));
    }

    public static int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0, sum = 0;
        map.put(0, 1);
        for (int i : nums) {
            sum = (i + sum) % k;
            if (sum < 0) {
                sum += k;
            }
            if (map.containsKey(sum)) {
                count += map.get(sum);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
