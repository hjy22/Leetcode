package String;

import java.util.Arrays;

public class LongestCommonPrefix14E {
    public static void main(String[] args) {
        String[] strs = { "dog","racecar","car" };
        System.out.println(longestCommonPrefix(strs));
    }

    public static String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs, (str1, str2) -> {
            return str1.length() - str2.length();
        });
        String ans = "";
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (c != strs[j].charAt(i)) {
                    return ans;
                }
            }
            ans += c;
        }
        return ans;
    }
}
