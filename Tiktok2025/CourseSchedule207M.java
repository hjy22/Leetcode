package Tiktok2025;

import java.util.LinkedList;
import java.util.List;

// https://leetcode.com/problems/course-schedule/
public class CourseSchedule207M {
    static boolean hasCycle = false;
    static boolean[] visited;
    static boolean[] onPath;

    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = { { 1, 0 } };
        System.out.println(canFinish(numCourses, prerequisites));
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = buildGraph(numCourses, prerequisites);
        visited = new boolean[numCourses];
        onPath = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            traverse(graph, i);
        }
        return !hasCycle;
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
        visited[i] = true;
        onPath[i] = true;
        for (int vertex : graph[i]) {
            traverse(graph, vertex);
        }
        onPath[i] = false;
    }
}
