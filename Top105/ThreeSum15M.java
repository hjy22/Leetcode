package Top105;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/3sum/?envType=study-plan-v2&envId=top-interview-150
public class ThreeSum15M {
    public static void main(String[] args) {
        int[] nums = { -4, -1, -1, 0, 1, 2 };
        System.out.println(threeSum(nums));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            twoSum(nums, ans, i);
        }
        return ans;
    }

    public static void twoSum(int[] nums, List<List<Integer>> ans, int index) {
        int left = index + 1, right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right] + nums[index];
            if (sum == 0) {
                ans.add(Arrays.asList(nums[index], nums[left], nums[right]));
                while (left < right && nums[left] == nums[left + 1]) {
                    left++;
                }
                while (left < right && nums[right] == nums[right - 1]) {
                    right--;
                }
                left++;
                right--;
            } else if (sum > 0) {
                right--;
            } else {
                left++;
            }
        }
    }

}
