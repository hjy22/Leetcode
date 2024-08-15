package Labuladong.SliceWindows;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class DegreeofanArray697E {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 2, 3, 1 };
        System.out.println(findShortestSubArray(nums));
    }

    public static int findShortestSubArray(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        int maxCount = Integer.MIN_VALUE;
        Map<Integer, Integer> maxMap = new HashMap<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            maxCount = Math.max(maxCount, entry.getValue());
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (maxCount == entry.getValue()) {
                maxCount = entry.getValue();
                maxMap.put(entry.getKey(), maxCount);
            }
        }

        int ans = Integer.MAX_VALUE;
        for (Map.Entry<Integer, Integer> entry : maxMap.entrySet()) {
            int maxValue = entry.getKey();
            int left = 0, right = 0;
            int meetDegree = 0;
            int minLength = Integer.MAX_VALUE;
            while (right < nums.length) {
                System.out.println(right + " " + nums[right]);
                if (nums[right] == maxValue) {
                    meetDegree++;
                }
                right++;
                while (meetDegree == maxCount) {
                    if (nums[left] == maxValue) {
                        meetDegree--;
                    }
                    left++;
                    minLength = Math.min(minLength, right - left + 1);
                }

            }
            ans = Math.min(minLength, ans);
        }

        return ans;
    }
}
