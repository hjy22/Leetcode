package DP;

import java.util.Arrays;
import java.util.*;

//https://leetcode.com/problems/minimum-cost-for-tickets/
public class MinimumCostForTickets983M {
    public static void main(String[] args) {
        int[] days = { 1, 4, 6, 7, 8, 20 };
        int[] costs = { 7, 2, 15 };
        System.out.println(mincostTickets(days, costs));
    }

    public static int mincostTickets(int[] days, int[] costs) {
        int[] ans = new int[days[days.length - 1] + 1];
        Arrays.fill(ans, Integer.MAX_VALUE);
        ans[0] = 0;
        int validDay = 0;
        for (int i = 1; i < ans.length; i++) {
            if (i != days[validDay]) {
                ans[i] = ans[i - 1];
            } else {
                validDay++;
                ans[i] = Math.min(ans[i], ans[i - 1] + costs[0]);

                int index = Math.max(0, i - 7);
                int temp1 = ans[index] + costs[1];
                index = Math.max(0, i - 30);
                int temp2 = ans[index] + costs[2];
                int minTemp = Math.min(temp1, temp2);
                ans[i] = Math.min(ans[i], minTemp);
            }

        }
        return ans[ans.length - 1];
    }
}
