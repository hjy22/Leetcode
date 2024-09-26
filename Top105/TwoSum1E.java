package Top105;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/two-sum/description/?envType=study-plan-v2&envId=top-interview-150
public class TwoSum1E {
    public static void main(String[] args) {
        int[] nums = { 2, 7, 11, 15 };
        int target = 9;
        int[] ans = twoSum(nums, target);
        System.out.println(ans[0] + " " + ans[1]);
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
