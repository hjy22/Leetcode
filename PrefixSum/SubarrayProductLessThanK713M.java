package PrefixSum;

import java.util.HashMap;
import java.util.Map;

public class SubarrayProductLessThanK713M {
    public static void main(String[] args) {
        int[] nums = {10,5,2,6};
        int x=100;
        System.out.println(numSubarrayProductLessThanK(nums,x));
    }

    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        int sum = 1;
        int ans = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<k){
                ans++;
            }
            int left =0;
            for(left<i&&)
        }
    }
}
