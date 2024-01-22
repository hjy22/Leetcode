package Array;

//https://leetcode.com/problems/number-of-arithmetic-triplets/
public class NumberofArithmeticTriplets2367E {
    public static void main(String[] args) {
        int[] nums = { 0, 1, 4, 6, 7, 10 };
        int diff = 3;
        System.out.println(arithmeticTriplets(nums, diff));
    }

    public static int arithmeticTriplets(int[] nums, int diff) {
        int ans = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            int start = nums[i];
            int count = 1;
            for (int j = i + 1; j < nums.length; j++) {
                if (start + diff == nums[j]) {
                    count++;
                    start = nums[j];
                }
                if (count == 3) {
                    ans++;
                    break;
                }
            }
        }
        return ans;
    }
}
