package Google;

import java.util.Stack;

// https://leetcode.com/problems/asteroid-collision/?envType=company&envId=google&favoriteSlug=google-thirty-days
public class AsteroidCollision735M {
    public static void main(String[] args) {
        int[] asteroids = { 5, 10, -5 };
        System.out.println(asteroidCollision(asteroids));
    }

    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int asteroid : asteroids) {
            boolean alive = true;
            while(!stack.isEmpty()&&stack.peek()>0&&asteroid<0){
                if(Math.abs(stack.peek())>Math.abs(asteroid)){
                    alive=false;
                    break;
                }else if(Math.abs(stack.peek())<Math.abs(asteroid)){
                    stack.pop();
                }else{
                    stack.pop();
                    alive =false;
                    break;
                }
            }
            if(alive){
                stack.push(asteroid);
            }
        }

        int[] result = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; --i) {
            result[i] = stack.pop();
        }
        
        return result;
    }
}
