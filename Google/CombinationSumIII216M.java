package Google;

import java.util.ArrayList;
import java.util.List;

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

    public static void backTrack(int k, int n, List<Integer> track, int sum, int start) {
        if (track.size() == k && sum == n) {
            ans.add(new ArrayList<>(track));
            return;
        }
        if (sum > n || track.size() > k) {
            return;
        }
        for (int i = start; i <=9; i++) {
            if (sum > n) {
                continue;
            }
            sum += i;
            track.add(i);
            backTrack(k, n, track, sum, i + 1);
            sum -= i;
            track.remove(track.size() - 1);
        }
    }
}
