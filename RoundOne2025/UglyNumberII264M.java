package RoundOne2025;

// https://leetcode.com/problems/ugly-number-ii/?show=1
public class UglyNumberII264M {
    public static void main(String[] args) {
        int n = 10;
        System.out.println(nthUglyNumber(n));
    }

    public static int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        int p2 = 0, p3 = 0, p5 = 0;
        for (int i = 1; i < n; i++) {
            int next = Math.min(Math.min(dp[p2] * 2, dp[p3] * 3), dp[p5] * 5);
            dp[i] = next;
            if (dp[p2] * 2 == next) {
                p2++;
            }
            if (dp[p3] * 3 == next) {
                p3++;
            }
            if (dp[p5] * 5 == next) {
                p5++;
            }
        }
        return dp[n - 1];
    }
}
