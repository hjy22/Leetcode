package TwoPointer;

//https://leetcode.com/problems/squares-of-a-sorted-array/
public class SquaresOfASortedArray977E {
    public static void main(String[] args) {
        int[] nums = {-4,-1,0,3,10};
        System.out.println(sortedSquares(nums));
    }
    public static int[] sortedSquares(int[] nums) {
        int left=0,right=nums.length-1,p=nums.length-1;
        int[] ans = new int[nums.length];
        while(left<=right){
            int leftSquare = (int)Math.pow(nums[left], 2);
            int rightSquare = (int)Math.pow(nums[right], 2);
            if(leftSquare<rightSquare){
                ans[p]=rightSquare;
                right--;
            }else{
                ans[p]=leftSquare;
                left++;
            }
            p--;
        }
        return ans;
    }
}
