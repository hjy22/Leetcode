package Labuladong.SliceWindows;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/contains-duplicate-ii/
public class ContainsDuplicateII219E {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 1 };
        int k = 3;
        System.out.println(containsNearbyDuplicate(nums, k));
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                if (Math.abs(map.get(nums[i]) - i) <= k) {
                    return true;
                }
            }
            //若索引的绝对值超过k，也需要更新map里nums[i]存的value的值
            map.put(nums[i], i);
        }
        return false;
    }
}
