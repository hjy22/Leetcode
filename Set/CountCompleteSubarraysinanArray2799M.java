package Set;

import java.util.HashSet;
import java.util.Set;

public class CountCompleteSubarraysinanArray2799M {
    public static void main(String[] args) {
        int[] nums = { 1, 3, 1, 2, 2 };
        System.out.println(countCompleteSubarrays(nums));
    }

    public static int countCompleteSubarrays(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int ans = 0;
        for (int i : nums) {
            set.add(i);
        }
        int size = set.size();
        for (int i = 0; i < nums.length; i++) {
            Set<Integer> tmpSet = new HashSet<>();
            for (int j = i; j < nums.length; j++) {
                tmpSet.add(nums[j]);
                if (tmpSet.size() == size) {
                    ans++;
                }
            }
            
        }
        return ans;
    }
}
