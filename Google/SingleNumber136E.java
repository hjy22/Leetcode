package Google;

// https://leetcode.com/problems/single-number/?envType=company&envId=google&favoriteSlug=google-thirty-days
public class SingleNumber136E {
    public static void main(String[] args) {
        int[] nums = { 2, 2, 1 };
        System.out.println(singleNumber(nums));
    }

    public static int singleNumber(int[] nums) {
        int n = 0;
        for (int i : nums) {
            n ^= i;
        }
        return n;
    }
}
