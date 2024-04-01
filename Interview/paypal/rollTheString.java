package Interview.paypal;

import java.util.*;
import java.lang.*;

public class rollTheString {
    public static void main(String[] args){
        String s="abz";
        List<Integer> roll = new ArrayList<>();
        roll.add(3);
        System.out.println(newRollTheString(s,roll));
    }
    public static String rollTheString(String s, List<Integer> roll) {
        // Write your code here
        String ans = s;
        for (int i = 0; i < roll.size(); i++) {
            ans = roll(ans, roll.get(i));
        }
        return ans;
    }

    public static String newRollTheString(String s, List<Integer> roll) {
        String ans = "";
        int[] times = new int[s.length()];
        for(int i=0;i<roll.size();i++){
            for(int j=0;j<roll.get(i);j++){
                times[j]+=1;
            }
        }
        for (int i = 0; i < s.length(); i++) {
            char shift = (char) ((s.charAt(i)-'a'+times[i])%26+'a');
            ans += shift;
        }
        return ans;
    }

    private static String roll(String s, int length) {
        String ans = "";
        for (int i = 0; i < length; i++) {
            char shift = (char) ((s.charAt(i)-'a'+1)%26+'a');
            ans += shift;
        }
        for (int i = length; i < s.length(); i++) {
            ans += s.charAt(i);
        }
        return ans;
    }
}