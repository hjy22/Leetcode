package Tiktok2025.SecondRound;

import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/rotated-digits/
public class RotatedDigits788M {
    public static void main(String[] args) {
        int n = 10;
        System.out.println(rotatedDigits(n));
    }

    public static int rotatedDigits(int n) {
        int count = 0;
        List<Integer> badList = Arrays.asList(3, 4, 7);
        List<Integer> goodList = Arrays.asList(2, 5, 6, 9);
        for (int i = 0; i <= n; i++) {
            if (isGoodNumber(i, badList, goodList)) {
                count++;
            }
        }
        return count;
    }

    public static boolean isGoodNumber(int n, List<Integer> badList, List<Integer> goodList) {
        boolean hasDifferent = false;
        while (n > 0) {
            int digit = n % 10;
            if (badList.contains(digit)) {
                return false;
            } else if (goodList.contains(digit)) {
                hasDifferent = true;
            }
            n /= 10;
        }
        return hasDifferent;
    }
}
