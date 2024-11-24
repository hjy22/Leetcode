package Google;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/
public class NumberofConnectedComponentsinanUndirectedGraph323M {
    static int[] parent;
    static int[] rank;

    public static void main(String[] args) {
        int[][] edges = { { 0, 1 }, { 1, 2 }, { 3, 4 } };
        int n = 5;
        System.out.println(countComponents(n, edges));
    }

    public static int countComponents(int n, int[][] edges) {
        // initialize the graph
        initialize(n, edges);
        // union all the edges
        for (int[] edge : edges) {
            union(edge[0], edge[1]);
        }
        // the size of the root
        Set<Integer> set = new HashSet<>();
        for (int index : parent) {
            set.add(find((index)));
        }
        return set.size();
    }

    public static void initialize(int n, int[][] edges) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    public static int find(int edge) {
        if (parent[edge] != edge) {
            parent[edge] = find(parent[edge]);
        }
        return parent[edge];
    }

    public static void union(int edge1, int edge2) {
        int parent1 = find(edge1);
        int parent2 = find(edge2);

        if(parent1!=parent2){
            if (rank[parent1] < rank[parent2]) {
                parent[parent1] = parent2;
            } else if (rank[parent1] > rank[parent2]) {
                parent[parent2] = parent1;
            } else {
                parent[parent1] = parent2;
                rank[parent2]++;
            }
        }
        
    }
}
