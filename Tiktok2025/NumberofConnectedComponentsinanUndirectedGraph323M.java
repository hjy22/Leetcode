package Tiktok2025;

// https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/
public class NumberofConnectedComponentsinanUndirectedGraph323M {
    public static void main(String[] args) {
        int[][] edges = { { 0, 1 }, { 1, 2 }, { 3, 4 } };
        int n = 5;
        System.out.println(countComponents(n, edges));
    }

    public static int countComponents(int n, int[][] edges) {
        int count = 0;
        int[] parent = new int[n];
        int[] rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
            count++;
        }
        for (int[] edge : edges) {
            if(union(edge[0], edge[1], parent,rank)){
                count--;
            }
        }
        return count;
    }

    public static boolean union(int e1, int e2, int[] parent,int[] rank) {
        int root1 = find(e1, parent);
        int root2 = find(e2, parent);
        if (root1 == root2) {
            return false;
        }
        if (rank[root1] > rank[root2]) {
            parent[root2] = root1;
        } else if (rank[root1] < rank[root2]) {
            parent[root1] = root2;
        } else {
            parent[root2] = root1;
            rank[root1]++;
        }
        return true;
    }

    public static int find(int e, int[] parent) {
        if (parent[e] != e) {
            parent[e] = find(parent[e], parent);
        }
        return parent[e];
    }
}
