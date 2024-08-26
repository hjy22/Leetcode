package Backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// https://leetcode.com/problems/combinations/
public class Combinations77M {
    static List<List<Integer>> ans = new ArrayList<>();

    public static void main(String[] args) {
        int n = 4;
        int k = 2;
        System.out.println(combine(n, k));
    }

    public static List<List<Integer>> combine(int n, int k) {
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(track, n, k, 1);
        return ans;
    }

    public static void backtrack(LinkedList<Integer> track, int n, int k, int start) {
        if (track.size() == k) {
            ans.add(new ArrayList<>(track));
        }
        if (start > n) {
            return;
        }

        for (int i = start; i <= n; i++) {
            if(track.size()>k){
                continue;
            }
            track.add(i);
            backtrack(track, n, k, i+1);
            track.removeLast();
        }
    }
}
