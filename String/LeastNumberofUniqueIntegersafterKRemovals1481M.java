package String;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


//https://leetcode.com/problems/least-number-of-unique-integers-after-k-removals/
public class LeastNumberofUniqueIntegersafterKRemovals1481M {
    public static void main(String[] args) {
        // 2 4 8 5
        // 1 3
        int[] arr = { 2, 4, 1, 8, 3, 5, 1, 3 };
        int k = 3;
        System.out.println(findLeastNumOfUniqueInts(arr, k));
    }

    public static int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> map = new TreeMap<>();

        for (Integer i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        int num = map.size();

        List<Map.Entry<Integer, Integer>> mapList = new ArrayList<>(map.entrySet());
        mapList.sort((o1, o2) -> o1.getValue() - o2.getValue());

        for (Map.Entry<Integer, Integer> entry : mapList) {
            Integer value = entry.getValue();

            k -= value;
            if (k >= 0) {
                num--;
            } else {
                break;
            }
        }
        return num;
    }
}
