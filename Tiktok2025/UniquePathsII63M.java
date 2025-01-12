package Tiktok2025;

// https://leetcode.com/problems/unique-paths-ii/?envType=company&envId=tiktok&favoriteSlug=tiktok-thirty-days
public class UniquePathsII63M {
    public static void main(String[] args) {
        int[][] obstacleGrid = { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } };
        System.out.println(uniquePathsWithObstacles(obstacleGrid));
    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] numOfPath = new int[obstacleGrid.length][obstacleGrid[0].length];
        if (obstacleGrid[0][0] == 1 || obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1] == 1) {
            return 0;
        }
        numOfPath[0][0] = 1;
        for (int i = 1; i < obstacleGrid.length; i++) {
            if (obstacleGrid[i][0] == 0 && numOfPath[i - 1][0] == 1) {
                numOfPath[i][0] = 1;
            } else {
                numOfPath[i][0] = 0;
            }
        }

        for (int i = 1; i < obstacleGrid[0].length; i++) {
            if (obstacleGrid[0][i] == 0&& numOfPath[0][i-1] == 1) {
                numOfPath[0][i] = 1;
            } else {
                numOfPath[0][i] = 0;
            }
        }
        for (int i = 1; i < numOfPath.length; i++) {
            for (int j = 1; j < numOfPath[0].length; j++) {
                if (obstacleGrid[i][j] != 1) {
                    numOfPath[i][j] += numOfPath[i - 1][j];
                    numOfPath[i][j] += numOfPath[i][j - 1];
                } else {
                    numOfPath[i][j] = 0;
                }
            }

        }
        return numOfPath[numOfPath.length - 1][numOfPath[0].length - 1];
    }
}
