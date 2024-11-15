package Labuladong.List;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/two-sum/
public class TwoSum1E {
    public static void main(String[] args) {
        int[] nums = { 3,2,4};
        int target = 6;
        System.out.println(twoSum(nums, target));
    }

    public static int[] twoSum(int[] nums, int target) {
         Map<Integer, Integer> map = new HashMap<>();
        int[] ans = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])){
                ans[0]=map.get(nums[i]);
                ans[1]=i;
                break;
            }
            map.put(target-nums[i], i);
        }
        return ans;
    }
}
