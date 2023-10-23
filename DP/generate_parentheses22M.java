package DP;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//https://leetcode.com/problems/generate-parentheses/
public class generate_parentheses22M {
    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }

    public static List<String> generateParenthesis(int n) {
        Set<String> set = new HashSet<>();
        set.add("()");
        for(int i=1;i<n;i++){
            Set<String> setResult = new HashSet<>();
            for(String setItem: set){
                for(int j=0;j<=setItem.length();j++){
                    setResult.add(buildString(setItem,j));
                }
            }
            set = setResult;
        }
        return convertSetToList(set);
    }

    static String buildString(String str, int index){
        return str.substring(0,index)+"()"+str.substring(index);
    }

    static List<String> convertSetToList(Set<String> set){
        List<String> array = new ArrayList<>();
        for(String setItem: set){
            array.add(setItem);
        }
        return array;
    }
}
