package Tiktok2025.SecondRound;

// https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/
public class NumberofConnectedComponentsinanUndirectedGraph323M {
    static int count;
    public static void main(String[] args) {
        int[][] edges = { { 0, 1 }, { 1, 2 }, { 3, 4 } };
        int n = 5;
        System.out.println(countComponents(n, edges));
    }

    public static int countComponents(int n, int[][] edges) {
        int[] parent = new int[n];
        count=n;
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        for (int[] edge : edges) {
            union(edge[0], edge[1], parent);
        }
        return count;
    }

    public static void union(int e1, int e2, int[] parent) {
        int root1 = findParent(e1, parent);
        int root2 = findParent(e2, parent);
        if (root1 != root2) {
            parent[root1] = root2;
            count--;
        }
    }

    public static int findParent(int e, int[] parent) {
        if (parent[e] != e) {
            parent[e] = findParent(parent[e], parent);
        }
        return parent[e];
    }
}
