package TwoPointer;

//https://leetcode.com/problems/minimum-operations-to-reduce-x-to-zero/
/*
 * 这个问题可以转换为另一个等价问题来解决：找到数组中最长的子数组，使得其元素和等于数组总和减去 X。通过这种方式，你可以通过反向思考问题，从而求解最小操作次数。类似325题
 */
public class MinimumOperationstoReduceXtoZero1658M {
    public static void main(String[] args) {
        int[] nums = {8828,9581,49,9818,9974,9869,9991,10000,10000,10000,9999,9993,9904,8819,1231,6309};
        int x=134365;
        System.out.println(minOperations(nums,x));
    }

    public static int minOperations(int[] nums, int x) {
        int totalSum = 0;
        for(int i=0;i<nums.length;i++){
            totalSum+=nums[i];
        }
        int target =totalSum-x;
        int left=0;
        int sum =0;
        int maxLen=-1;
        for (int right = 0; right < nums.length; right++) {
            sum+=nums[right];
            while(target<sum&&left<=right){
                sum-=nums[left];
                left++;
            }
            if(target==sum){
                maxLen=Math.max(right-left+1, maxLen);
            }
        }
        return maxLen==-1?-1:nums.length-maxLen;
    }
}
