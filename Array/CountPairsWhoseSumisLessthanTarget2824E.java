package Array;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/count-pairs-whose-sum-is-less-than-target/
public class CountPairsWhoseSumisLessthanTarget2824E {
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>();

        nums.add(10);
        nums.add(20);
        nums.add(30);
        int target = 0;
        System.out.println(countPairs(nums, target));
    }

    public static int countPairs(List<Integer> nums, int target) {
        int ans = 0;
        for (int i = 0; i < nums.size() - 1; i++) {
            for (int j = i + 1; j < nums.size(); j++) {
                if (nums.get(i) + nums.get(j) < target) {
                    ans++;
                }
            }
        }
        return ans;
    }
}
