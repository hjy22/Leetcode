package Top105;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.com/problems/group-anagrams/?envType=study-plan-v2&envId=top-interview-150
public class GroupAnagrams49M {
    public static void main(String[] args) {
        String[] strs = { "eat", "tea", "tan", "ate", "nat", "bat" };
        System.out.print(groupAnagrams(strs));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            String num = encode(str);
            map.putIfAbsent(num, new ArrayList<>());
            map.get(num).add(str);
        }
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            List<String> list = entry.getValue();
            ans.add(list);
        }
        return ans;
    }

    public static String encode(String str) {
        int[] num = new int[26];
        for (Character c : str.toCharArray()) {
            num[c - 'a']++;
        }
        //必须用这个方法，不然返回的地址不一样
        return Arrays.toString(num);
    }
}
