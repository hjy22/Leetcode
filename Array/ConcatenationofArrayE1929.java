package Array;

//https://leetcode.com/problems/concatenation-of-array/description/
public class ConcatenationofArrayE1929 {
    public static void main(String[] args) {
        int[] nums = { -1, 0, 3, 5, 9, 12 };
        System.out.println(getConcatenation(nums));
    }

    public static int[] getConcatenation(int[] nums) {
        int[] ans = new int[nums.length*2];
        for(int i =0;i<nums.length;i++){
            ans[i] = nums[i];
            ans[i+nums.length] = nums[i];
        }
        return ans;
    }
}
