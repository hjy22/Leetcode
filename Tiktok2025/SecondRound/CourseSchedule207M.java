package Tiktok2025.SecondRound;

import java.util.LinkedList;
import java.util.List;

// https://leetcode.com/problems/course-schedule/description/
public class CourseSchedule207M {
    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = { { 1, 0 } };
        System.out.println(canFinish(numCourses, prerequisites));
    }

    static boolean[] onPath;
    static boolean[] visited;
    static boolean hasCycle= false;
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = buildGraph(numCourses, prerequisites);
        onPath = new boolean[numCourses];
        visited = new boolean[numCourses];
        for(int i=0;i<numCourses;i++){
            traverse(graph, i);
        }
        return !hasCycle;
    }

    public static void traverse( List<Integer>[] graph,int i){
        if(hasCycle){
            return;
        }
        if(onPath[i]){
            hasCycle = true;
            return;
        }
        if(visited[i]){
            return;
        }
       
        visited[i]=true;
        onPath[i]=true;
        for(int vertex:graph[i]){
            traverse(graph, vertex);
        }
        onPath[i]=false;
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
