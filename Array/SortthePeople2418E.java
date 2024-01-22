package Array;

import java.util.Map;
import java.util.TreeMap;

//https://leetcode.com/problems/sort-the-people/
public class SortthePeople2418E {
    public static void main(String[] args) {
        String[] names = { "Mary", "John", "Emma" };
        int[] heights = { 180, 165, 170 };
        System.out.println(sortPeople(names, heights));
    }

    public static String[] sortPeople(String[] names, int[] heights) {
        String[] ans = new String[names.length];
        Map<Integer, String> map = new TreeMap<>();
        for (int i = 0; i < names.length; i++) {
            map.put(heights[i], names[i]);
        }
        int i = ans.length-1;
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            ans[i] = entry.getValue();
            i--;
            System.out.println(entry.getKey()+entry.getValue());
        }
        return ans;
    }
}
