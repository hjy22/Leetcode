package SuiXiangLu;

// https://leetcode.com/problems/squares-of-a-sorted-array/
public class SquaresofASortedArray977E {
    public static void main(String[] args) {
        int[] nums = { -4, -1, 0, 3, 10 };
        int[] ans = sortedSquares(nums);
        for (int i : ans) {
            System.out.print(i + " ");

        }
    }

    public static int[] sortedSquares(int[] nums) {
        int left = 0, right = nums.length - 1;
        int[] ans = new int[nums.length];
        int index =nums.length-1;
        while (index>=0) {
            int leftSquare = (int) Math.pow(nums[left], 2);
            int rightSquare = (int) Math.pow(nums[right], 2);
            if(leftSquare>rightSquare){
                ans[index]=leftSquare;
                left++;
            }else{
                ans[index]=rightSquare;
                right--;
            }
            index--;
        }
        return ans;
    }
}
