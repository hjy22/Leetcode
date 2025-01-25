package Tiktok2025;

// https://leetcode.com/problems/unique-binary-search-trees/?envType=company&envId=tiktok&favoriteSlug=tiktok-three-months
public class UniqueBinarySearchTrees96M {
    public static void main(String[] args) {
        System.out.println(numTrees(3));
    }

    public static int numTrees(int n) {
        int[][] memo = new int[n + 1][n + 1];
        return count(1, n, memo);
    }

    public static int count(int low, int high, int[][] memo) {
        if (low > high) {
            return 1;
        }

        if (memo[low][high] != 0) {
            return memo[low][high];
        }

        int count = 0;
        for (int i = low; i <= high; i++) {
            int left = count(low, i - 1, memo);
            int right = count(i + 1, high, memo);
            count += left * right;
        }
        memo[low][high] = count;
        return count;
    }
}
