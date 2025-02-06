package Tiktok2025.SecondRound;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/combination-sum-iii/
public class CombinationSumIII216M {
    public static void main(String[] args) {
        int k = 3, n = 7;
        System.out.println(combinationSum3(k, n));
    }

    static List<List<Integer>> ans = new ArrayList<>();

    public static List<List<Integer>> combinationSum3(int k, int n) {
        backTrack(n, k, 0, 1, new ArrayList<>());
        return ans;
    }

    public static void backTrack(int target, int size, int sum, int start, List<Integer> list) {
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
            backTrack(target, size, sum, i + 1, list);
            sum -= i;
            list.remove(list.size() - 1);
        }
    }
}
