package RoundOne2025;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/contains-duplicate-ii/description/
public class ContainsDuplicateII219E {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 1 };
        int x = 3;
        System.out.println(containsNearbyDuplicate(nums, x));
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (map.containsKey(num)) {
                if (Math.abs(map.get(num) - i) <= k) {
                    return true;
                }
            }
            map.put(num, i);
        }
        return false;
    }
}
