package Top105;

// https://leetcode.com/problems/product-of-array-except-self/description/?envType=study-plan-v2&envId=top-interview-150
public class ProductofArrayExceptSelf238M {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4 };
        int[] ans = productExceptSelf(nums);
        for (int i : ans) {
            System.out.print(i + " ");

        }
    }

    public static int[] productExceptSelf(int[] nums) {
        int[] prefix = new int[nums.length];
        int[] surfix = new int[nums.length];
        int[] ans = new int[nums.length];
        prefix[0] = 1;
        surfix[nums.length - 1] = 1;
        for (int i = 1; i < nums.length; i++) {
            // 不包括 nums[i] 的所有前面元素的乘积
            prefix[i] = prefix[i - 1] * nums[i-1];
        }

        for (int i = nums.length - 2; i >= 0; i--) {
            // 不包括 nums[i] 的所有后面元素的乘积
            surfix[i] = surfix[i + 1] * nums[i+1];
        }

        for (int i = 0; i < nums.length; i++) {
            ans[i] = surfix[i ] * prefix[i];
        }
        return ans;
    }
}
/*
 * 1 2 6 24
 * 24 24 12 4
 */