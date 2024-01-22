package Array;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/check-if-a-string-is-an-acronym-of-words/
public class CheckifaStringIsanAcronymofWords2828E {
    public static void main(String[] args) {
        List<String> words = new ArrayList<>();
        words.add("an");
        words.add("apple");
        String s = "a";
        System.out.println(isAcronym(words, s));
    }

    public static boolean isAcronym(List<String> words, String s) {
        int i = 0;
        if(words.size()!=s.length()){
            return false;
        }
        for (String str : words) {
            if (str.charAt(0) != s.charAt(i)) {
                return false;
            }
            i++;
        }
        return true;
    }
}
