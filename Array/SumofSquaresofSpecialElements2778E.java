package Array;

//https://leetcode.com/problems/sum-of-squares-of-special-elements/
public class SumofSquaresofSpecialElements2778E {
    public static void main(String[] args) {
        int[] nums = { 2, 7, 1, 19, 18, 3 };
        System.out.println(sumOfSquares(nums));
    }

    public static int sumOfSquares(int[] nums) {
        int ans = 0;
        int length = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (length % (i+1) == 0) {
                System.out.print(nums[i]+" ");
                ans += nums[i] * nums[i];
            }
        }
        return ans;
    }
}
