package Array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://leetcode.com/problems/intersection-of-three-sorted-arrays/
public class IntersectionofThreeSortedArrays1213E {
    public static void main(String[] args) {
        int[] arr1 = { 1, 2, 3, 4, 5 };
        int[] arr2 = { 1, 2, 3, 4, 5 };
        int[] arr3 = { 1, 2, 3, 4, 5 };
        System.out.println(arraysIntersection(arr1, arr2, arr3));
    }

    public static List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        List<Integer> ans = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        addTimes(arr1, map);
        addTimes(arr2, map);
        addTimes(arr3, map);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int value = entry.getValue();
            int key = entry.getKey();
            if (value == 3) {
                ans.add(key);
            }
        }
        return ans;
    }

    public static void addTimes(int[] arr, Map<Integer, Integer> map) {
        for (Integer i : arr) {
            if (map.keySet().contains(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }
    }
}
