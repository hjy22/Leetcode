package Tiktok2025;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// https://leetcode.com/problems/min-cost-to-connect-all-points/
public class MinCosttoConnectAllPoints1584M {
    public static void main(String[] args) {
        int[][] points = { { 0, 0 }, { 2, 2 }, { 3, 10 }, { 5, 2 }, { 7, 0 } };
        System.out.println(minCostConnectPoints(points));
    }

    public static int minCostConnectPoints(int[][] points) {
        List<int[]> weights = new ArrayList<>();
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                int x1 = points[i][0], y1 = points[i][1];
                int x2 = points[j][0], y2 = points[j][1];
                int weight = Math.abs(x1 - x2) + Math.abs(y1 - y2);
                weights.add(new int[] { i, j, weight });
            }
        }

        Collections.sort(weights, (a, b) -> {
            return a[2] - b[2];
        });

        int[] parent = new int[points.length];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        int sum = 0, count = 0;
        for (int[] weight : weights) {
            int e1 = weight[0], e2 = weight[1];
            int w1 = weight[2];
            if (find(e1, parent) != find(e2, parent)) {
                union(e1, e2, parent);
                count++;
                sum += w1;
            }

            if (count == points.length - 1) {
                return sum;
            }
        }
        return 0;
    }

    public static void union(int e1, int e2, int[] parent) {
        int root1 = find(e1, parent);
        int root2 = find(e2, parent);
        if (root1 != root2) {
            parent[root1] = root2;
        }
    }

    public static int find(int e, int[] parent) {
        if (parent[e] != e) {
            parent[e] = find(parent[e], parent);
        }
        return parent[e];
    }
}
