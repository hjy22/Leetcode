package Array;

//https://leetcode.com/problems/count-number-of-pairs-with-absolute-difference-k/
public class CountNumberofPairsWithAbsoluteDifferenceK2006E {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 2, 1 };
        int k = 1;
        System.out.println(countKDifference(nums, k));
    }

    public static int countKDifference(int[] nums, int k) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (Math.abs(nums[j] - nums[i]) == k) {
                    ans++;
                }
            }
        }
        return ans;
    }
}
