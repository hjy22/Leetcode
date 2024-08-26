package TopologicalSorting;

import java.util.LinkedList;
import java.util.List;

// https://leetcode.com/problems/course-schedule/
public class CourseSchedule207M {
    static boolean hasCycle = false;
    static boolean[] visited,onPath;

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

    public static void traverse(List<Integer>[] graph, int i) {
        if (hasCycle|| visited[i]) {
            return;
        }
        if (onPath[i]) {
            hasCycle = true;
            return;
        }
        onPath[i]=true;
        visited[i] =true;
        for (int index : graph[i]) {
            traverse(graph, index);
        }
        onPath[i] = false;
    }

    public static List<Integer>[] buildGraph(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new LinkedList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new LinkedList<>();
        }

        // 根据课程先后顺序，创建有序图
        for (int[] edge : prerequisites) {
            graph[edge[1]].add(edge[0]);
        }
        return graph;
    }
}
