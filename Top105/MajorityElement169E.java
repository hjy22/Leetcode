package Top105;

import java.util.Arrays;

// https://leetcode.com/problems/majority-element/description/?envType=study-plan-v2&envId=top-interview-150
public class MajorityElement169E {
    public static void main(String[] args) {
        int[] nums = { 2, 2, 1, 1, 1, 2, 2 };
        System.out.println(majorityElement(nums));

    }

    public static int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
}
