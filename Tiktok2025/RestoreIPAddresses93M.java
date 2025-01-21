package Tiktok2025;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/restore-ip-addresses/
public class RestoreIPAddresses93M {
    static List<String> ans = new ArrayList<>();

    public static void main(String[] args) {
        String s = "25525511135";
        System.out.println(restoreIpAddresses(s));
    }

    public static List<String> restoreIpAddresses(String s) {

        backTrack(s, new ArrayList<>(), 0);
        return ans;
    }

    public static void backTrack(String s, List<String> list, int start) {
        if (list.size() == 4 && start == s.length()) {
            ans.add(String.join(".", list));
            return;
        }

        for (int i = start; i < s.length(); i++) {
            String str = s.substring(start, i + 1);
            if (!isValid(str)) {
                continue;
            }
            list.add(str);
            backTrack(s, list, i + 1);
            list.remove(list.size() - 1);
        }
    }

    public static boolean isValid(String s) {
        if (s.length() > 3) {
            return false;
        }
        if (s.startsWith("0") && s.length() != 1) {
            return false;
        }
        if (Integer.valueOf(s) > 255 || Integer.valueOf(s) < 0) {
            return false;
        }
        return true;
    }
}
