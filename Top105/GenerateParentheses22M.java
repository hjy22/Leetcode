package Top105;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/generate-parentheses/?envType=study-plan-v2&envId=top-interview-150
public class GenerateParentheses22M {
    static List<String> ans = new ArrayList<>();

    public static void main(String[] args) {
        int n = 3;
        System.out.println(generateParenthesis(n));
    }

    public static List<String> generateParenthesis(int n) {
        String str = "";
        backtrack(n, n, str);
        return ans;
    }

    public static void backtrack(int left, int right, String str) {
        if (right < left) {
            return;
        }
        if (left < 0 || right < 0) {
            return;
        }
        if (left == 0 & right == 0) {
            ans.add(str);
            return;
        }

        // try left
        str += "(";
        backtrack(left - 1, right, str);
        str = str.substring(0, str.length() - 1);

        str += ")";
        backtrack(left, right - 1, str);
        str = str.substring(0, str.length() - 1);
    }
}
