package RoundOne2025;

import java.util.Stack;

// https://leetcode.com/problems/simplify-path/description/
public class SimplifyPath71M {
    public static void main(String[] args) {
        String path = "/home/";
        System.out.println(simplifyPath(path));
    }

    public static String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] pathArray = path.split("/");
        for (String str : pathArray) {
            if (!stack.isEmpty() && str.equals("..")) {
                stack.pop();
            } else if (!str.isEmpty() && !str.equals(".") && !str.equals("..")) {
                stack.push(str);
            }
        }
        if (stack.isEmpty()) {
            return "/";
        }
        StringBuilder sb = new StringBuilder();

        for (String str : stack) {
            sb.append("/").append(str);
        }
        return sb.toString();
    }
}
