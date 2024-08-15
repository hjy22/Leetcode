package DP;

//https://leetcode.com/problems/climbing-stairs/
public class ClimbingStairs70E {
    public static void main(String[] args) {
        int n = 4;
        System.out.println(climbStairs(n));
    }

    public static int climbStairsRecursion(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }

        int stepOne = climbStairsRecursion(n - 1);
        int stepTwo = climbStairsRecursion(n - 2);

        return stepOne + stepTwo;
    }

    // 0 1 2 3 4 5  
    // 0 1 2 3 5 8
    public static int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int[] array = new int[n + 1];
        array[0] = 0;
        array[1] = 1;
        array[2] = 2;
        for (int i = 3; i <= n; i++) {
            array[i] = array[i - 1] + array[i - 2];
        }
        return array[n];
    }
}
