package Tiktok2025;

import java.util.Arrays;

// https://leetcode.com/problems/connecting-cities-with-minimum-cost/
public class ConnectingCitiesWithMinimumCost1135M {
    public static void main(String[] args) {
        int[][] connections = { { 1, 2, 5 }, { 1, 3, 6 }, { 2, 3, 1 } };
        int n = 3;
        System.out.println(minimumCost(n, connections));
    }

    public static int minimumCost(int n, int[][] connections) {
        int[] parent = new int[n + 1];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        int ans = 0, count = 0;
        ;
        Arrays.sort(connections, (a, b) -> {
            return a[2] - b[2];
        });
        for (int[] connection : connections) {
            int e1 = connection[0];
            int e2 = connection[1];
            int weight = connection[2];
            if (find(e1, parent) == find(e2, parent)) {
                continue;
            }
            union(e1, e2, parent);
            ans += weight;
            count++;
            if (count == n - 1) {
                return ans;
            }
        }
        return -1;
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
