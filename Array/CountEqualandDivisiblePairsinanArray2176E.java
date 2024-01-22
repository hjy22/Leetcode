package Array;

//https://leetcode.com/problems/count-equal-and-divisible-pairs-in-an-array/
public class CountEqualandDivisiblePairsinanArray2176E {
    public static void main(String[] args) {
        int[] nums = { 2, 7, 1, 19, 18, 3 };
        int k = 0;
        System.out.println(countPairs(nums, k));
    }

    public static int countPairs(int[] nums, int k) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] != nums[j]) {
                    continue;
                }
                if (i * j % k != 0) {
                    continue;
                }
                ans++;
            }
        }
        return ans;
    }
}
