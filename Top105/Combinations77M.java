package Top105;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/combinations/?envType=study-plan-v2&envId=top-interview-150
public class Combinations77M {
    static List<List<Integer>> ans = new ArrayList<>();

    public static void main(String[] args) {
        int n = 4, k = 2;
        System.out.println(combine(n, k));
    }

    public static List<List<Integer>> combine(int n, int k) {
        List<Integer> list = new ArrayList<>();
        backtrack(1, n, k, list);
        return ans;
    }

    public static void backtrack(int value, int n, int k, List<Integer> list) {
        if (list.size() == k) {
            ans.add(new ArrayList<>(list));
            return;
        }
        if (value > n) {
            return;
        }
        for (int i = value; i <= n; i++) {
            list.add(i);
            backtrack(i+1, n, k, list);
            list.remove(list.size() - 1);
        }
    }
}
