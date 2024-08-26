package Backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// https://leetcode.com/problems/combination-sum-iii/
public class CombinationSumIII216M {
    static List<List<Integer>> ans = new ArrayList<>();

    public static void main(String[] args) {
        int k = 3;
        int n = 7;
        System.out.println(combinationSum3(k, n));
    }

    public static List<List<Integer>> combinationSum3(int k, int n) {
        LinkedList<Integer> track = new LinkedList<>();
        backTrack(track, 0, n, k, 1);
        return ans;
    }

    public static void backTrack(LinkedList<Integer> track, int sum, int target, int num, int start) {
        if (track.size() == num && sum == target) {
            ans.add(new ArrayList<>(track));
            return;
        }

        if (track.size() > num || sum > target) {
            return;
        }

        for (int i = start; i <= 9; i++) {
            if (sum > target) {
                continue;
            }
            track.add(i);
            sum += i;
            // backtrack
            backTrack(track, sum, target, num, i+1);
            // 删除元素
            track.removeLast();
            sum -= i;
        }
    }
}
