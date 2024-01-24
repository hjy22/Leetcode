package Array;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

//https://leetcode.com/problems/convert-an-array-into-a-2d-array-with-conditions/
public class ConvertanArrayIntoa2DArrayWithConditions2610E {
    public static void main(String[] args) {
        int[] nums = { 1, 3, 4, 1, 2, 3, 1 };
        System.out.println(findMatrix(nums));
    }

    public static List<List<Integer>> findMatrix(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }
        int max = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int maxValue = entry.getValue();
            max = Math.max(max, maxValue);
        }
        while (max > 0) {
            List<Integer> tempList = new ArrayList<>();
            ans.add(tempList);
            max--;
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int times = entry.getValue();
            int value = entry.getKey();
            int index=0;
            while (times > 0) {
                ans.get(index).add(value);
                times--;
                index++;
            }
        }
        return ans;
    }
}
