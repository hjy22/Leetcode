package TopologicalSorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

// https://leetcode.com/problems/course-schedule-ii
public class CourseScheduleII210M {
    static boolean hasCycle = false;
    static boolean[] visited, onPath;
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = { { 1, 0 } };
        System.out.println(findOrder(numCourses, prerequisites));
    }

    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        if (!canFinish(numCourses, prerequisites)) {
            return new int[] {};
        }
        Collections.reverse(list);
        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
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
        if (onPath[i]) {
            hasCycle = true;
            return;
        }
        if (hasCycle || visited[i]) {
            return;
        }

        onPath[i] = true;
        visited[i] = true;

        for (int index : graph[i]) {
            traverse(graph, index);
        }
        list.add(i);
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
