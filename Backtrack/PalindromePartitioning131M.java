package Backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// https://leetcode.com/problems/palindrome-partitioning/
public class PalindromePartitioning131M {
    static List<List<String>> ans = new ArrayList<>();

    public static void main(String[] args) {
        String s = "aab";
        System.out.println(partition(s));
    }

    public static List<List<String>> partition(String s) {
        LinkedList<String> track = new LinkedList<>();
        backtrack(s, track, 0);
        return ans;
    }

    public static void backtrack(String s,LinkedList<String> track,int start){
        if(start==s.length()){
            ans.add(new ArrayList<>(track));
            return;
        }
        for(int i=start;i<s.length();i++){
            String subString = s.substring(start, i+1);
            if(!isPalindrome(subString)){
                continue;
            }
            track.add(subString);
            backtrack(s, track, i+1);
            track.removeLast();
        }
    }

    public static boolean isPalindrome(String str){
        int left=0,right=str.length()-1;
        while (left<right) {
            if(str.charAt(left)!=str.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
