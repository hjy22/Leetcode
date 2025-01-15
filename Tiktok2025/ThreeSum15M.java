package Tiktok2025;

// https://leetcode.com/problems/3sum/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum15M {
    public static void main(String[] args) {
        int[] nums = { -1, 0, 1, 2, -1, -4 };
        System.out.println(threeSum(nums));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if(i>0&&nums[i]==nums[i-1]){
                continue;
            }
            twoSum(ans, i, nums);
        }
        return ans;
    }

    public static void twoSum(List<List<Integer>> ans, int index, int[] nums) {
        int left = index + 1, right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right] + nums[index];
            if (sum > 0) {
                right--;
            } else if (sum < 0) {
                left++;
            } else {
                ans.add(Arrays.asList(nums[index], nums[left], nums[right]));
                while (left < right && nums[right] == nums[right - 1]) {
                    right--;
                }
                while (left < right && nums[left] == nums[left + 1]) {
                    left++;
                }
                right--;
                left++;
            }
        }
    }
}
