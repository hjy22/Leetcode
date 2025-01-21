package Tiktok2025;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/numbers-with-same-consecutive-differences/
public class NumbersWithSameConsecutiveDifferences967M {
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        int n = 3, k = 7;
        System.out.println(numsSameConsecDiff(n, k));
    }

    public static int[] numsSameConsecDiff(int n, int k) {
        for (int i = 1; i <= 9; i++) {
            backTrack(n, k, i, 1);
        }
        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }

    public static void backTrack(int n, int k, int num, int index) {
        if (index == n ) {
            list.add(num);
            return;
        }
        int lastDigit = num % 10;
        if (lastDigit + k <= 9) {
            backTrack(n, k, num * 10 + lastDigit + k, index + 1);
        }
        if (k > 0 && lastDigit - k >= 0) {
            backTrack(n, k, num * 10 + lastDigit - k, index + 1);
        }
    }
}
