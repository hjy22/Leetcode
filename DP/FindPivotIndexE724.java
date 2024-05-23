package DP;

public class FindPivotIndexE724 {
    public static void main(String[] args) {
        int[] nums = {2,1,-1};
        System.out.println(pivotIndex(nums));
    }

    public static int pivotIndex(int[] nums) {
        int[] newNums = new int[nums.length+1];
        newNums[0]=0;
        for(int i=1;i<newNums.length;i++){
            newNums[i]=nums[i-1]+newNums[i-1];
        }   
        int sum = newNums[newNums.length-1];
        for(int i=1;i<newNums.length;i++){
            int left=newNums[i-1];
            int right = sum-newNums[i];
            if(left==right){
                return i-1;
            }
        }
        return -1;
    }
}
