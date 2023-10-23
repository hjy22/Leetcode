package array;

//https://leetcode.com/problems/find-triangular-sum-of-an-array/
public class triangularSum2221M {
    public static void main(String[] args) {
        int[] nums = {1,1};
        System.out.println(triangularSum(nums));
    }

    public static int triangularSum(int[] nums) {
        int ans = 0;
        if(nums.length==1){
            return nums[0];
        }
        int[] originArray = nums;
        int[] nextArray = originArray;
        while(nextArray.length>1){
            nextArray = new int[originArray.length-1];
            for(int i=0;i<nextArray.length;i++){
                int temp = originArray[i]+originArray[i+1];
                nextArray[i]= temp%10;
            }
            originArray = nextArray;
        }
        ans = nextArray[0];
        return ans;
    }
}
