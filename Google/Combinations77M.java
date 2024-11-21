package Google;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/combinations/
public class Combinations77M {
    static List<List<Integer>> ans = new ArrayList<>();

    public static void main(String[] args) {
        int n = 4, k = 2;
        System.out.println(combine(n, k));
    }

    public static List<List<Integer>> combine(int n, int k) {
        backTrack(n, k, new ArrayList<>(), 1);
        return ans;
    }

    public static void backTrack(int n, int k, List<Integer> track, int start) {
        if (track.size() == k) {
            ans.add(new ArrayList<>(track));
            return;
        }
        for (int i = start; i <= n; i++) {
            track.add(i);
            backTrack(n, k, track, i + 1);
            track.remove(track.size() - 1);
        }
    }
}
