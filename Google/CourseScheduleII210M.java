package Google;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// https://leetcode.com/problems/course-schedule-ii/
public class CourseScheduleII210M {
    static boolean hasCycle = false;
    static boolean[] visited;
    static boolean[] onPath;
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = { { 1, 0 } };
        System.out.println(findOrder(numCourses, prerequisites));
    }

    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = buildGraph(numCourses, prerequisites);
        visited = new boolean[numCourses];
        onPath = new boolean[numCourses];
        for(int i=0;i<numCourses;i++){
            traverse(graph, i);

        }
        if (hasCycle) {
            return new int[] {};
        }
        int[] ans = new int[numCourses];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(list.size()-1-i);
        }
        return ans;
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

        onPath[i] = true;
        visited[i] = true;
        for (int edge : graph[i]) {
            traverse(graph, edge);
        }
        list.add(i);
        onPath[i] = false;
    }
}
