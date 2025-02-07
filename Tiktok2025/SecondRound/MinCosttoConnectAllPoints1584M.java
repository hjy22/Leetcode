package Tiktok2025.SecondRound;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinCosttoConnectAllPoints1584M {
    public static void main(String[] args) {
        int[][] points = { { 0, 0 }, { 2, 2 }, { 3, 10 }, { 5, 2 }, { 7, 0 } };
        System.out.println(minCostConnectPoints(points));
    }

    public static int minCostConnectPoints(int[][] points) {
        List<int[]> pointInfos = new ArrayList<>();
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                int x1 = points[i][0], y1 = points[i][1];
                int x2 = points[j][0], y2 = points[j][1];
                int distance = Math.abs(x1 - x2) + Math.abs(y1 - y2);
                pointInfos.add(new int[] { i, j, distance });
            }
        }

        Collections.sort(pointInfos, (a, b) -> {
            return a[2] - b[2];
        });

        int[] parent = new int[points.length];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        int distanceSum = 0, count = 0;
        for (int[] p : pointInfos) {
            int p1 = p[0], p2 = p[1], distance = p[2];
            if (findParent(p1, parent) != findParent(p2, parent)) {
                union(p1, p2, parent);
                distanceSum += distance;
                count++;
                if (count == points.length - 1) {
                    return distanceSum;
                }
            }

        }

        return 0;
    }

    public static void union(int e1, int e2, int[] parent) {
        int root1 = findParent(e1, parent);
        int root2 = findParent(e2, parent);
        if (root1 != root2) {
            parent[root1] = root2;
        }
    }

    public static int findParent(int e, int[] parent) {
        if (parent[e] != e) {
            parent[e] = findParent(parent[e], parent);
        }
        return parent[e];
    }
}
