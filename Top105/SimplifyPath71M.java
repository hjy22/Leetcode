package Top105;

import java.util.Stack;

// https://leetcode.com/problems/simplify-path/?envType=study-plan-v2&envId=top-interview-150
public class SimplifyPath71M {
    public static void main(String[] args) {
        String path = "/../";
        // String path = "/.../a/../b/c/../d/./";
        // String path = "/home//foo/";
        System.out.println(simplifyPath(path));

    }

    public static String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] strArr = path.split("/");
        for (String str : strArr) {
            if (!stack.isEmpty()&&str.equals( "..")) {
                stack.pop();
            } else if (!str.isEmpty()&&!str.equals(".")&&!str.equals("..")) {
                stack.push(str);
            }
        }
        if (stack.isEmpty()) {
            return "/";
        }
        
        StringBuilder ans = new StringBuilder();
        for (String dir : stack) {
            ans.append("/").append(dir);
        }
        
        return ans.toString();
    }
}
