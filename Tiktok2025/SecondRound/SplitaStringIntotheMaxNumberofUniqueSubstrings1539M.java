package Tiktok2025.SecondRound;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/split-a-string-into-the-max-number-of-unique-substrings/
public class SplitaStringIntotheMaxNumberofUniqueSubstrings1539M {
    public static void main(String[] args) {
        String s = "ababccc";
        System.out.println(maxUniqueSplit(s));
    }

    public static int maxUniqueSplit(String s) {
        backTrack(s, 0);
        return maxLen;
    }

    static List<String> list = new ArrayList<>();
    static int maxLen = 0;
    public static void backTrack(String s,int index ){
        if(index==s.length()){
           maxLen = Math.max(list.size(), maxLen);
           return;
        }
        for(int i=index;i<s.length();i++){
            String subStr = s.substring(index, i+1);
            if(!list.contains(subStr)){
                list.add(subStr);
                backTrack(s, i+1);
                list.remove(list.size()-1);
            }
        }
    }
}
