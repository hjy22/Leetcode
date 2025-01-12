package Tiktok2025;

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
        List<int[]> list = new ArrayList<>();
        int i = 0, j = 0;
        while (i < firstList.length && j < secondList.length) {
            int a1 = firstList[i][0], a2 = firstList[i][1];
            int b1 = secondList[j][0], b2 = secondList[j][1];
            if (a1 <= b2 && a2 >= b1) {
                int c1 = Math.max(a1, b1);
                int c2 = Math.min(a2, b2);
                list.add(new int[] { c1, c2 });
            }
            if (b2 > a2) {
                i++;
            } else {
                j++;
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}
