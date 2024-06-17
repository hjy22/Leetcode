package PrefixSum;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/subarray-sum-equals-k/
public class SubarraySumEqualsK560M {
    public static void main(String[] args) {
        int[] nums = { 1,2,3};
        int k = 3;
        System.out.println(subarraySum(nums, k));
    }

    public static int subarraySum(int[] nums, int k) {
        int[] sumArray = new int[nums.length + 1];
        HashMap<Integer, Integer> map = new HashMap<>();
        //初始化前缀和是0时的值为1
        map.put(0, 1);
        int ans =0;
        sumArray[0] = 0;
        for (int i = 1; i < sumArray.length; i++) {
            sumArray[i] = sumArray[i - 1] + nums[i-1];
            int remainder = sumArray[i]-k;
            if(map.containsKey(remainder)){
                ans+=map.get(remainder);
            }
            map.put(sumArray[i], map.getOrDefault(sumArray[i], 0) + 1);
           
        }
        return ans;
    }
}
