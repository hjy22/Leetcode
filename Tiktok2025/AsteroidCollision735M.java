package Tiktok2025;

import java.util.Stack;

// https://leetcode.com/problems/asteroid-collision/?envType=company&envId=tiktok&favoriteSlug=tiktok-three-months
public class AsteroidCollision735M {
    public static void main(String[] args) {
        int[] asteroids = { -2,1,1,-1 };
        int[] ans = asteroidCollision(asteroids);
        for (int a : ans) {
            System.out.print(a + " ");
        }
    }

    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int asteroid : asteroids) {
            boolean alive = true;
            while (!stack.isEmpty() && asteroid < 0 && stack.peek() > 0) {
                int previous = stack.peek();
                System.out.println(asteroid + " " + previous);
                if (previous + asteroid < 0) {
                    stack.pop();
                    continue;
                } else if (previous + asteroid > 0) {
                    alive = false;
                    break;
                } else {
                    alive = false;
                    stack.pop();
                    break;
                }
            }
            if (alive) {
                stack.push(asteroid);
            }
        }
        int[] ans = new int[stack.size()];
        for (int i = ans.length - 1; i >= 0; i--) {
            ans[i] = stack.pop();
        }
        return ans;
    }
}
