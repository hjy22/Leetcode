package String;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/di-string-match/submissions/1159657675/
public class DIStringMatch942E {
    public static void main(String[] args) {
        String s = "IDID";
        System.out.println(diStringMatch(s));
    }

    public static int[] diStringMatch(String s) {
        List<Integer> list = new ArrayList<>();
        int start = 0;
        int end = s.length();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'I') {
                list.add(start);
                start++;
            } else {
                list.add(end);
                end--;
            }
        }
        if (s.charAt(s.length() - 1) == 'I') {
            list.add(start);
        } else {
            list.add(end);
        }
        int[] ans = new int[list.size()];
        for (int j = 0; j < ans.length; j++) {
            ans[j] = list.get(j);
        }
        return ans;
    }
}
