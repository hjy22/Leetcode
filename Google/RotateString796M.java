package Google;

// https://leetcode.com/problems/rotate-string/?envType=company&envId=google&favoriteSlug=google-thirty-days
public class RotateString796M {
    public static void main(String[] args) {
        String s = "abcde", goal = "cdeab";
        System.out.println(rotateString(s,goal));
    }

    public static boolean rotateString(String s, String goal) {
        String combine = s+s;
        return combine.contains(goal)&&s.length()==goal.length(); 
    }
}
