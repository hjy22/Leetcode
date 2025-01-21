package Tiktok2025;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/generate-parentheses/
public class GenerateParentheses22M {
    static List<String> ans = new ArrayList<>();

    public static void main(String[] args) {
        int n = 3;
        System.out.println(generateParenthesis(n));
    }

    public static List<String> generateParenthesis(int n) {
        backTrack(n, n, "");
        return ans;
    }

    public static void backTrack(int left, int right, String str) {
        if (left > right) {
            return;
        }
        if (left < 0 || right < 0) {
            return;
        }
        if (left == 0 && right == 0) {
            ans.add(str);
            return;
        }
        backTrack(left - 1, right, str + '(');
        backTrack(left, right - 1, str + ')');
    }
}
