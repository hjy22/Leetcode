package Array;

//https://leetcode.com/problems/running-sum-of-1d-array/
public class RunningSumof1dArray1480E {
    public static void main(String[] args) {
        int[] nums = { 5, 7, 7, 8, 8, 10 };
        System.out.println(runningSum(nums));
    }

    public static int[] runningSum(int[] nums) {
        int[] ans =new int[nums.length];
        ans[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            ans[i]=ans[i-1]+nums[i];
        }
        return ans;
    }
}
