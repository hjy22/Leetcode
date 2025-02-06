package Tiktok2025.SecondRound;

import java.util.Stack;

// https://leetcode.com/problems/asteroid-collision/?envType=company&envId=tiktok&favoriteSlug=tiktok-three-months
public class AsteroidCollision735M {
    public static void main(String[] args) {
        int[] asteroids = { 5, 10, -5 };
        int[] ans = asteroidCollision(asteroids);
        for (int i : ans) {
            System.out.println(i);
        }
    }

    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for(int asteroid:asteroids){
            boolean alive = true;
            while (alive&&!stack.isEmpty()&&asteroid<0&&stack.peek()>0) {
                if(asteroid+stack.peek()>0){
                    alive=false;
                    break;
                }else if(asteroid+stack.peek()<0){
                    stack.pop();
                }else{
                    stack.pop();
                    alive = false;
                }
            }
            if(alive){
                stack.push(asteroid);
            }
        }
        int[] ans = new int[stack.size()];
        for(int i=ans.length-1;i>=0;i--){
            ans[i]=stack.pop();
        }
        return ans;
    }
}
