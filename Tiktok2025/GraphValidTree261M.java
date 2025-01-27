package Tiktok2025;

// https://leetcode.com/problems/graph-valid-tree/
public class GraphValidTree261M {
    public static void main(String[] args) {
        int[][] edges = { { 0, 1 }, { 0, 2 }, { 0, 3 }, { 1, 4 } };
        int n = 5;
        System.out.println(validTree(n, edges));
    }

    public static boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) {
            return false;
        }
        // initialize
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        for (int[] edge : edges) {
            if (connected(edge[0], edge[1], parent)) {
                return false;
            }
            union(edge[0], edge[1], parent);
        }
        return true;
        // connect
        // find
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

    public static boolean connected(int e1, int e2, int[] parent) {
        return find(e1, parent) == find(e2, parent);
    }
}
