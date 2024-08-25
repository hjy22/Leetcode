package DP;

// https://leetcode.com/problems/edit-distance/
public class EditDistance72M {
    public static void main(String[] args) {
        String word1 = "horse", word2 = "ros";
        System.out.println(minDistance(word1, word2));
    }

    public static int minDistance(String word1, String word2) {
        // int i = word1.length(), j = word2.length();
        // int ans = recursion(word1, i - 1, word2, j - 1);
        int ans = dp(word1, word2);
        return ans;
    }

    public static int dp(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 1; j <= n; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n ; j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = min(
                            dp[i - 1][j - 1] + 1,
                            dp[i][j - 1] + 1,
                            dp[i - 1][j] + 1);
                }
            }
        }
        return dp[m][n];
    }

    public static int recursion(String word1, int i, String word2, int j) {
        if (i == -1)
            return j + 1;
        if (j == -1)
            return i + 1;

        if (word1.charAt(i) == word2.charAt(j)) {
            return recursion(word1, i - 1, word2, j - 1);
        } else {
            return min(
                    // delete
                    recursion(word1, i - 1, word2, j) + 1,

                    // insert
                    recursion(word1, i, word2, j - 1) + 1,

                    // replace
                    recursion(word1, i - 1, word2, j - 1) + 1);
        }
    }

    public static int min(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }
}
