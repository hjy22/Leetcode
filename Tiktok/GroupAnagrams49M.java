package Tiktok;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.com/problems/group-anagrams/?envType=company&envId=tiktok&favoriteSlug=tiktok-thirty-days
public class GroupAnagrams49M {
    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        System.out.println(groupAnagrams(strs));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        for(String str:strs){
            String decode = decodeString(str);
            map.putIfAbsent(decode, new ArrayList<>());
            map.get(decode).add(str);
        }

        List<List<String>> list = new ArrayList<>();
        for(Map.Entry<String,List<String>> entry:map.entrySet()){
            list.add(entry.getValue());
        }
        return list;
    }

    public static String decodeString(String str){
        int[] charArray = new int[26];
        for(Character c:str.toCharArray()){
            charArray[c-'a']++;
        }
        return Arrays.toString(charArray);
    }
}
