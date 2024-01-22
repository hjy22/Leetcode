package Array;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/find-common-elements-between-two-arrays/
public class FindCommonElementsBetweenTwoArrays2956E {
    public static void main(String[] args) {
        int[] nums1 = { 4, 3, 2, 3, 1 };
        int[] nums2 = { 2, 2, 5, 2, 3, 6 };
        System.out.println(findIntersectionValues(nums1, nums2));
    }

    public static int[] findIntersectionValues(int[] nums1, int[] nums2) {
        int[] ans = new int[2];
        int count1=getNum(nums1, nums2);
        System.out.println("============");
        int count2=getNum(nums2, nums1);
        
        ans[0]=count1;
        ans[1]=count2;
        return ans;
    }

    public static int getNum(int[] nums1, int[] nums2) {
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            if (map.keySet().contains(nums2[i])) {
                map.put(nums2[i], map.get(nums2[i]) + 1);
            } else {
                map.put(nums2[i], 1);
            }
        }
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            Integer value = entry.getValue();
            Integer key = entry.getKey();
            System.out.println("value"+value+"key"+key);
        }
        for (int i : nums1) {
            Integer times = map.get(i);
            if (times == null) {
                continue;
            } else {
                if (times >= 1) {
                    count++;
                }
            }
        }
        return count;
    }
}
