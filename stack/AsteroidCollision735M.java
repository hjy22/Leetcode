package Array;

import java.util.Stack;

//https://leetcode.com/problems/asteroid-collision/
public class AsteroidCollision735M {
    public static void main(String[] args) {
        int[] intervals = { 5,10,-5 };
        System.out.println(asteroidCollision(intervals));
    }

    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for(int asteroid : asteroids) {
            boolean alive = true;
            while (!stack.isEmpty()&&asteroid<0&&stack.peek()>0) {
                if(Math.abs(asteroid)>stack.peek()){
                    stack.pop();
                }else if(Math.abs(asteroid)==stack.peek()){
                    stack.pop();
                    alive=false;
                    break;
                }else{
                    alive=false;
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
