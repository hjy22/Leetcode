package Array;

//https://leetcode.com/problems/find-pivot-index/description/
public class FindPivotIndex724E {
    public static void main(String[] args) {
        int[] nums = { 1, 7, 3, 6, 5, 6 };
        System.out.println(pivotIndex(nums));
    }

    public static int pivotIndex(int[] nums) {
        int sum = 0;
        int leftnum=0;
        for(int item:nums){
            sum+=item;
        }
        System.out.println(sum);
        for(int i=0;i<nums.length;i++){
            if(leftnum==sum-nums[i]){
                return i;
            }else{
                leftnum+=nums[i];
                sum-=nums[i];
            }
        }
        return -1;
    }
}