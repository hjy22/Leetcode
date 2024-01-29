package Array;

import java.util.Arrays;

//https://leetcode.com/problems/find-greatest-common-divisor-of-array/
public class FindGreatestCommonDivisorofArray1979E {
    public static void main(String[] args) {
        int[] nums = { 2, 5, 6, 9, 10 };
        System.out.println(findGCD(nums));
    }

    public static int findGCD(int[] nums) {
        int ans = 0;
        Arrays.sort(nums);
        System.out.println(nums[0]);
        ans = GCD(nums[0], nums[nums.length - 1]);
        return ans;
    }

    public static int GCD(int num1, int num2) {
        int ans = 0;
        if (num2 % num1 == 0) {
            ans = num1;
        } else {
            for (int i = num1; i >=0; i--) {
                if (num1 % i == 0 && num2 % i == 0) {
                    ans = i;
                    break;
                }
            }
        }
        return ans;
    }
}
