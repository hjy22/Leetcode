package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://leetcode.com/problems/group-anagrams/description/
public class GroupAnagrams49M {
    public static void main(String[] args) {
        String[] strs = { "eat", "tea", "tan", "ate", "nat", "bat" };
        System.out.println(groupAnagrams(strs));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for(String str:strs){
            String encodeString = encode(str);
            map.putIfAbsent(encodeString, new ArrayList<>());
            map.get(encodeString).add(str);
        }
        for(Map.Entry<String, List<String>> entry:map.entrySet()){
            ans.add(entry.getValue());
        }
        return ans;
    }

    public static String encode(String str) {
        int[] charArray = new int[26];
        for (char c : str.toCharArray()) {
            int index = c - 'a';
            charArray[index]++;
        }
        return Arrays.toString(charArray);
    }
}
