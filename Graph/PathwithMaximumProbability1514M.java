package Graph;

import java.util.*;

import javafx.util.Pair;

//https://leetcode.com/problems/path-with-maximum-probability/description/
public class PathwithMaximumProbability1514M {
    public static void main(String[] args) {
        int n = 3;
        int[][] edges = { { 0, 1 }, { 1, 2 }, { 0, 2 } };
        double[] succProb = { 0.5, 0.5, 0.2 };
        int start = 0;
        int end = 2;
        maxProbability(n, edges, succProb, start, end);
    }

    public static double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        Map<Integer, List<Pair<Integer, Double>>> graph = new HashMap<>();
        int[] edge;
        for (int i = 0; i < edges.length; i++) {
            edge = edges[i];
            graph.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(new Pair<>(edge[1], succProb[i]));
            graph.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(new Pair<>(edge[0], succProb[i]));
        }
        System.out.println(graph);
        double[] maxProb = new double[n];
        maxProb[start_node] = 1.0;

        PriorityQueue<Pair<Integer, Double>> queue = new PriorityQueue<>(
                (a, b) -> -Double.compare(a.getValue(), b.getValue()));
        queue.add(new Pair<>(start_node, 1.0));

        while (!queue.isEmpty()) {
            Pair<Integer, Double> curr = queue.poll();
            if (curr.getKey() == end_node)
                return curr.getValue();
            for (Pair<Integer, Double> path : graph.getOrDefault(curr.getKey(), new ArrayList<>())) {
                if (curr.getValue() * path.getValue() > maxProb[path.getKey()]) {
                    maxProb[path.getKey()] = (double) curr.getValue() * path.getValue();
                    queue.add(new Pair<>(path.getKey(), maxProb[path.getKey()]));
                }
            }

        }
        return 1.0;
    }
}
