package Tiktok2025.SecondRound;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/interval-list-intersections/
public class IntervalListIntersections986M {
    public static void main(String[] args) {
        int[][] firstList = { { 0, 2 }, { 5, 10 }, { 13, 23 }, { 24, 25 } },
                secondList = { { 1, 5 }, { 8, 12 }, { 15, 24 }, { 25, 26 } };
        int[][] ans = intervalIntersection(firstList, secondList);
        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i][0] + " " + ans[i][1]);
        }
    }

    public static int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int i = 0, j = 0;
        List<int[]> list = new ArrayList<>();
        while (i < firstList.length && j < secondList.length) {
            int firstStart = firstList[i][0], firstEnd = firstList[i][1];
            int secondStart = secondList[j][0], secondEnd = secondList[j][1];
            if (firstEnd >= secondStart && secondEnd >= firstStart) {
                int i1 = Math.max(secondStart, firstStart);
                int i2 = Math.min(secondEnd, firstEnd);
                list.add(new int[] { i1, i2 });
            }
            if (firstEnd < secondEnd) {
                i++;
            } else {
                j++;
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}
