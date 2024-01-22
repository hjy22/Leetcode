package Array;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/find-anagram-mappings/
public class FindAnagramMappings760E {
    public static void main(String[] args) {
        int[] nums1 = { 12, 28, 46, 32, 50 };
        int[] nums2 = { 50, 12, 32, 46, 28 };
        int[] ans = anagramMappings(nums1, nums2);
        for (int i : ans) {
            System.out.println(i);
        }
    }

    public static int[] anagramMappings(int[] nums1, int[] nums2) {
        int[] ans = new int[nums2.length];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            map.put(nums2[i], i);
        }
        for (int i = 0; i < nums1.length; i++) {
            ans[i] = map.get(nums1[i]);
        }
        return ans;
    }
}
