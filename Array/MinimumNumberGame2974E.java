package Array;

import java.util.Arrays;

//https://leetcode.com/problems/minimum-number-game/
public class MinimumNumberGame2974E {
    public static void main(String[] args) {
        int[] nums = { 5, 7, 7, 8, 8, 10 };
        System.out.println(numberGame(nums));
    }

    public static int[] numberGame(int[] nums) {
        int[] ans = new int[nums.length];
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i=i+2){
            ans[i]=nums[i+1];
            ans[i+1]=nums[i];
        }
        return ans;
    }
}
