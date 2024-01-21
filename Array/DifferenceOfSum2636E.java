package Array;

//https://leetcode.com/problems/difference-between-element-sum-and-digit-sum-of-an-array/
public class DifferenceOfSum2636E {
    public static void main(String[] args) {
        int[] nums = { 1, 15, 6, 3 };
        System.out.println(differenceOfSum(nums));
    }

    public static int differenceOfSum(int[] nums) {
        int elementSum = 0;
        int digitSum = 0;
        for(int i=0;i<nums.length;i++){
            elementSum+=nums[i];
            digitSum+=splitInteger(nums[i]);
        }
        return Math.abs(elementSum-digitSum);
    }

    public static int splitInteger(int number) {
        int ans = 0;
        while (number / 10 != 0) {
            ans += number % 10;
            number = number / 10;
        }
        ans += number;
        return ans;
    }
}
