package Tiktok2025;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/palindrome-partitioning/
public class PalindromePartitioning131M {
    static List<List<String>> ans = new ArrayList<>();

    public static void main(String[] args) {
        String s = "aab";
        System.out.println(partition(s));
    }

    public static List<List<String>> partition(String s) {
        backTrack(s, new ArrayList<>(), 0);
        return ans;
    }

    public static void backTrack(String s, List<String> list, int index) {
        if (index == s.length()) {
            ans.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i < s.length(); i++) {
            String str = s.substring(index, i + 1);
            if (!isPalindrome(str)) {
                continue;
            }
            list.add(str);
            backTrack(s, list, i + 1);
            list.remove(list.size() - 1);
        }
    }

    public static boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
