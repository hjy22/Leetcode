package Array;

//https://leetcode.com/problems/is-subsequence/
public class IsSubsequence392E {
    public static void main(String[] args) {
        String s = "abc", t = "ahbgdc";
        System.out.println(isSubsequence(s, t));
    }

    public static boolean isSubsequence(String s, String t) {
        int p1 = 0, p2 = 0;
        while (p1 < s.length() && p2 < t.length()) {
            if(s.charAt(p1)==t.charAt(p2)){
                p1++;
            }
            p2++;
        }
        return p1==s.length();
    }
}
