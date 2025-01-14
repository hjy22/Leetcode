package Tiktok2025;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/combination-sum-iii/
public class CombinationSumIII216M {
    static List<List<Integer>> ans = new ArrayList<>();

    public static void main(String[] args) {
        int k = 3, n = 7;
        System.out.println(combinationSum3(k, n));
    }

    public static List<List<Integer>> combinationSum3(int k, int n) {
        backTrack(k, n, new ArrayList<>(), 0, 1);
        return ans;
    }

    public static void backTrack(int size, int target, List<Integer> list, int sum, int start) {
        if (sum == target && list.size() == size) {
            ans.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i <= 9; i++) {
            if (sum > target) {
                continue;
            }
            sum += i;
            list.add(i);
            backTrack(size, target, list, sum, i + 1);
            sum -= i;
            list.remove(list.size() - 1);
        }
    }
}
