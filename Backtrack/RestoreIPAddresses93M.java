package Backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class RestoreIPAddresses93M {
    static List<String> ans = new ArrayList<>();

    public static void main(String[] args) {
        String s = "25525511135";
        System.out.println(restoreIpAddresses(s));
    }

    public static List<String> restoreIpAddresses(String s) {
        LinkedList<String> track = new LinkedList<>();
        backtrack(s, track, 0);
        return ans;
    }

    public static void backtrack(String s, LinkedList<String> track, int start) {
        if (track.size() == 4 && start == s.length()) {
            ans.add(String.join(".", track));
            return; // 返回，避免继续遍历
        }
        for (int i = start; i < s.length(); i++) {
            String subString = s.substring(start, i + 1);
            if (!isValid(subString)) {
                continue;
            }
            track.add(subString);
            backtrack(s, track, i + 1);
            track.removeLast();
        }
    }

    static boolean isValid(String s) {
        if (s.length() > 3) {
            return false;
        }
        if (s.length() == 1) {
            return true;
        }
        if (s.charAt(0) == '0') {
            return false; // 前导零无效
        }
        int num = Integer.parseInt(s);
        return num >= 0 && num <= 255;
    }

}
