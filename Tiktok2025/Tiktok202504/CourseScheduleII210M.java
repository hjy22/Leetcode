package Tiktok2025.Tiktok202504;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// https://leetcode.com/problems/course-schedule-ii/?envType=company&envId=tiktok&favoriteSlug=tiktok-thirty-days
public class CourseScheduleII210M {
    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = { { 1, 0 } };
        System.out.println(findOrder(numCourses, prerequisites));
    }

    static boolean[] onPath;
    static boolean[] visited;
    static boolean hasCycle;
    static List<Integer> list = new ArrayList<>();

    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        onPath = new boolean[numCourses];
        visited = new boolean[numCourses];
        List<Integer>[] graph = buildGraph(numCourses, prerequisites);
        for (int i = 0; i < numCourses; i++) {
            traverse(graph, i);
        }
        if (hasCycle) {
            return new int[] {};
        }

        int size = list.size();
        int[] ans = new int[size];

        for (int i = 0; i < ans.length; i++) {
            ans[i] = list.get(size - i - 1);
        }
        return ans;
    }

    public static void traverse(List<Integer>[] graph, int i) {
        if (hasCycle) {
            return;
        }
        if (onPath[i]) {
            hasCycle = true;
            return;
        }
        if (visited[i]) {
            return;
        }
        onPath[i] = true;
        visited[i] = true;
        for (int edge : graph[i]) {
            traverse(graph, edge);
        }
        list.add(i);
        onPath[i] = false;
    }

    public static List<Integer>[] buildGraph(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new LinkedList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int[] prerequisite : prerequisites) {
            graph[prerequisite[1]].add(prerequisite[0]);
        }
        return graph;
    }
}
