package Labuladong.SliceWindows;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/longest-harmonious-subsequence/
public class LongestHarmoniousSubsequence594E {
    public static void main(String[] args) {
        int[] nums = { 1,3,2,2,5,2,3,7};
        System.out.println(findLHS(nums));
    }

    public static int findLHS(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        int maxLen=0;
        for(int i:nums){
            map.put(i, map.getOrDefault(i, 0)+1);
        }
        for(int i:nums){
            if(map.containsKey(i+1)){
                maxLen=Math.max(maxLen, map.get(i)+map.get(i+1));
            }
        }
        return maxLen;
    }
}
